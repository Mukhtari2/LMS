package com.example.LearningManagementSystem.mapper;

import com.example.LearningManagementSystem.dto.AssignmentRequestDTO;
import com.example.LearningManagementSystem.dto.AssignmentResponseDTO;
import com.example.LearningManagementSystem.model.Assignment;
import com.example.LearningManagementSystem.model.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.time.LocalDate;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, imports = {LocalDate.class})
public interface AssignmentMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "courseId", source = "course.id")
    @Mapping(target = "title", source = "requestDTO.title")
    @Mapping(target = "description", source = "requestDTO.description")
    Assignment toEntity(AssignmentRequestDTO requestDTO, Course course);
    AssignmentResponseDTO toDto(Assignment assignment);
}
