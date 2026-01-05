package com.example.LearningManagementSystem.Service;

import com.example.LearningManagementSystem.Dto.CourseRequestDTO;
import com.example.LearningManagementSystem.Dto.CourseResponseDTO;
import com.example.LearningManagementSystem.Model.Course;
import org.mapstruct.Mapper;

@Mapper
public interface CourseMapper {
    CourseResponseDTO toDto(Course course);
}
