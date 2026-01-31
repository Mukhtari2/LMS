package com.example.LearningManagementSystem.service;

import com.example.LearningManagementSystem.dto.UserRequestDto;
import com.example.LearningManagementSystem.dto.UserResponseDto;

public interface UserServices {
    UserResponseDto createUser (UserRequestDto requestDto);
    UserResponseDto updateUser (String userId, UserRequestDto userRequestDto);
    void removeUser (String userId);
}
