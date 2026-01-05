package com.example.LearningManagementSystem.Service;

import com.example.LearningManagementSystem.Dto.UserRequestDTO;
import com.example.LearningManagementSystem.Dto.UserResponseDTO;
import com.example.LearningManagementSystem.Model.User;

public interface UserService {
    UserResponseDTO register(UserRequestDTO request);

}
