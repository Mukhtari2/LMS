package com.example.LearningManagementSystem.mapper;

import com.example.LearningManagementSystem.dto.AssignmentRequestDTO;
import com.example.LearningManagementSystem.dto.AssignmentResponseDTO;
import com.example.LearningManagementSystem.model.Assignment;
import com.example.LearningManagementSystem.model.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, imports = {java.util.Date.class})
public interface AssignmentMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "course", source = "course")
    @Mapping(target = "title", source = "requestDTO.title")
    @Mapping(target = "description", source = "requestDTO.description")
    Assignment toEntity(AssignmentRequestDTO requestDTO, Course course);
    AssignmentResponseDTO toDto(Assignment assignment);
}
