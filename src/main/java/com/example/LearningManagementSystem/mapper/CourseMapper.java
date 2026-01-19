package com.example.LearningManagementSystem.mapper;

import com.example.LearningManagementSystem.dto.CourseRequestDTO;
import com.example.LearningManagementSystem.dto.CourseResponseDTO;
import com.example.LearningManagementSystem.model.Course;
import org.mapstruct.*;

import java.util.Optional;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public interface CourseMapper {


    CourseResponseDTO toDto(Course course);

    void updateEntityFromDto(CourseRequestDTO requestDTO, @MappingTarget Course existingCourse);


    }

