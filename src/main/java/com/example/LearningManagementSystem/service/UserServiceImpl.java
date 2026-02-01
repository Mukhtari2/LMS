package com.example.LearningManagementSystem.service;

import com.example.LearningManagementSystem.Enum.Role;
import com.example.LearningManagementSystem.exception.ResourceNotFoundException;
import com.example.LearningManagementSystem.dto.UserRequestDto;
import com.example.LearningManagementSystem.dto.UserResponseDto;
import com.example.LearningManagementSystem.model.User;
import com.example.LearningManagementSystem.model.VerificationToken;
import com.example.LearningManagementSystem.repository.UserRepository;
import com.example.LearningManagementSystem.repository.VerificationTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserServices{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final VerificationTokenRepository tokenRepository;
    private final JavaMailSender mailSender;

    @Override
    public UserResponseDto createUser(UserRequestDto requestDto) {
        User user = User.builder()
                .email(requestDto.getEmail())
                .password(passwordEncoder.encode(requestDto.getPassword()))
                .role(requestDto.getRole() != null ? requestDto.getRole() : Role.STUDENT)
                .enabled(false)
                .build();
        userRepository.save(user);

        String code = String.valueOf(new SecureRandom().nextInt(9000) + 1000);

        VerificationToken verificationToken = VerificationToken.builder()
                .token(code)
                .email(user.getEmail())
                .createdAt(LocalDateTime.now())
                .build();
        tokenRepository.save(verificationToken);

        sendEmail(user.getEmail(), code);

        return UserResponseDto.builder()
                .email(user.getEmail())
                .password(requestDto.getPassword())
                .build();
    }

    public boolean verifyCode(String email, String code) {
        Optional<VerificationToken> tokenOpt = tokenRepository.findByEmailAndToken(email, code);

        if (tokenOpt.isPresent()) {
            User user = userRepository.findByEmail(email)
                    .orElseThrow(() -> new RuntimeException("User not found"));
            user.setEnabled(true);
            userRepository.save(user);
            tokenRepository.delete(tokenOpt.get());
            return true;
        }
        return false;
    }

    private void sendEmail(String to, String code) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Verify Your Account");
        message.setText("Your 4-digit verification code is: " + code);
        mailSender.send(message);
    }

    @Override
    public UserResponseDto updateUser(String userId, UserRequestDto userRequestDto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        if (userRequestDto.getName() != null) {
            user.setName(userRequestDto.getName());
        }
        if (userRequestDto.getPassword() != null) {
            user.setPassword(passwordEncoder.encode(userRequestDto.getPassword()));
        }
        userRepository.save(user);
        return UserResponseDto.builder()
                .email(user.getEmail())
                .password("********")
                .build();
    }

    @Override
    public void removeUser(String userId) {
        if (!userRepository.existsById(userId)) {
            throw new ResourceNotFoundException("User with id " + userId + " not found");
        }
        userRepository.deleteById(userId);
    }
}
