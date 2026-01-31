package com.example.LearningManagementSystem.mapper;

import com.example.LearningManagementSystem.dto.CourseRequestDto;
import com.example.LearningManagementSystem.dto.CourseResponseDto;
import com.example.LearningManagementSystem.model.Course;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public interface CourseMapper {


    CourseResponseDto toDto(Course course);

    void updateEntityFromDto(CourseRequestDto requestDTO, @MappingTarget Course existingCourse);


    }

