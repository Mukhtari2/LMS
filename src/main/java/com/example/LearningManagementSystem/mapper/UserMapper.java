package com.example.LearningManagementSystem.mapper;

import com.example.LearningManagementSystem.dto.UserResponseDTO;
import com.example.LearningManagementSystem.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserResponseDTO toDto(User user);
}
