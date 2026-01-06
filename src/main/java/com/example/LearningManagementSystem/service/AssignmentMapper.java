package com.example.LearningManagementSystem.service;

import com.example.LearningManagementSystem.dto.AssignmentRequestDTO;
import com.example.LearningManagementSystem.dto.AssignmentResponseDTO;
import com.example.LearningManagementSystem.model.Assignment;
import com.example.LearningManagementSystem.model.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", imports = {java.util.Date.class})
public interface AssignmentMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "courseId", source = "course")
    @Mapping(target = "title", source = "request.getTitle")
    @Mapping(target = "description", source = "request.getDescription")
    @Mapping(target = "enrolledAt", expression = "java.newDate(System.currentTimeMillis())")
    Assignment toEntity(AssignmentRequestDTO requestDTO, Course course);
    AssignmentResponseDTO toDto(Assignment assignment);
}
