package com.example.LearningManagementSystem.Service;

import com.example.LearningManagementSystem.Dto.UserRequestDTO;
import com.example.LearningManagementSystem.Dto.UserResponseDTO;
import com.example.LearningManagementSystem.Model.User;
import com.example.LearningManagementSystem.Repository.UserRepository;
import lombok.Builder;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Data
@Builder
@Service
public class UserServiceImpl implements UserService {

    private UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private UserMapper userMapper;

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
