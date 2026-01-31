package com.example.LearningManagementSystem.mapper;

import com.example.LearningManagementSystem.dto.AssignmentRequestDto;
import com.example.LearningManagementSystem.dto.AssignmentResponseDto;
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
    Assignment toEntity(AssignmentRequestDto requestDTO, Course course);
    AssignmentResponseDto toDto(Assignment assignment);
}
