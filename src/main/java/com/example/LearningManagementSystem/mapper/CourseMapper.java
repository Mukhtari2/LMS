package com.example.LearningManagementSystem.mapper;

import com.example.LearningManagementSystem.dto.CourseResponseDTO;
import com.example.LearningManagementSystem.model.Course;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    CourseResponseDTO toDto(Course course);
}
