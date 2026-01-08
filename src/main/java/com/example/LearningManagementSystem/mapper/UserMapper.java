package com.example.LearningManagementSystem.mapper;

import com.example.LearningManagementSystem.dto.UserResponseDTO;
import com.example.LearningManagementSystem.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    UserResponseDTO toDto(User user);
}
