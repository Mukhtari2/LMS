package com.example.LearningManagementSystem.service;

import com.example.LearningManagementSystem.Enum.Role;
import com.example.LearningManagementSystem.authenticationAndAuthorization.AuthenticationRequest;
import com.example.LearningManagementSystem.authenticationAndAuthorization.AuthenticationResponse;
import com.example.LearningManagementSystem.authenticationAndAuthorization.JwtService;
import com.example.LearningManagementSystem.model.User;
import com.example.LearningManagementSystem.model.VerificationToken;
import com.example.LearningManagementSystem.repository.UserRepository;
import com.example.LearningManagementSystem.repository.VerificationTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    @Lazy
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final VerificationTokenRepository tokenRepository;
    private final JavaMailSender mailSender;


    @Override
    public AuthenticationResponse register(AuthenticationRequest request) {
        Role assignedRole;
        String requestedRole = request.getRole();

        if (requestedRole == null) {
            assignedRole = Role.ADMIN;
        } else {
            assignedRole = switch (requestedRole.toUpperCase()) {
                case "STUDENT" -> Role.STUDENT;
                case "TEACHER" -> Role.TEACHER;
                default -> Role.ADMIN;
            };
        }
        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(assignedRole)
                .enabled(false)
                .build();
        userRepository.insert(user);

        String code = String.valueOf(new SecureRandom().nextInt(9000) + 1000);

        VerificationToken token = VerificationToken.builder()
                .token(code)
                .email(user.getEmail())
                .createdAt(LocalDateTime.now())
                .build();
        tokenRepository.save(token);

        try {
            sendEmail(user.getEmail(), code);
        } catch (Exception e) {
            System.out.println("Mail sending failed: " + e.getMessage());
        }
        return AuthenticationResponse.builder()
                .message("User registered. Please check your email for the 4-digit code.")
                .build();
    }
    private void sendEmail(String to, String code) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Verification Code");
        message.setText("Your verification code is: " + code);
        mailSender.send(message);
    }

    @Override
    public AuthenticationResponse login(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .message("Login successful")
                .build();
    }
}
