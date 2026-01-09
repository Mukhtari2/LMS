package com.example.LearningManagementSystem.mapper;

import com.example.LearningManagementSystem.dto.CourseResponseDTO;
import com.example.LearningManagementSystem.model.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CourseMapper {
    CourseResponseDTO toDto(Course course);
}
