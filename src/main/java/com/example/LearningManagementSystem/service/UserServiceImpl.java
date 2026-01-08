package com.example.LearningManagementSystem.service;

import com.example.LearningManagementSystem.dto.UserRequestDTO;
import com.example.LearningManagementSystem.dto.UserResponseDTO;
import com.example.LearningManagementSystem.mapper.UserMapper;
import com.example.LearningManagementSystem.model.User;
import com.example.LearningManagementSystem.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    public UserResponseDTO register(UserRequestDTO request) {
        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();
        User newUser = repository.save(user);
        return userMapper.toDto(newUser);
    }
}
