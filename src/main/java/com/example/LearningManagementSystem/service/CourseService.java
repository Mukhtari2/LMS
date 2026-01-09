package com.example.LearningManagementSystem.service;

import com.example.LearningManagementSystem.dto.CourseRequestDTO;
import com.example.LearningManagementSystem.dto.CourseResponseDTO;
import com.example.LearningManagementSystem.model.Course;

import java.util.Optional;

public interface CourseService {
    CourseResponseDTO registerCourse(CourseRequestDTO requestDTO);

    Course updateCourse();

    Optional<Course> findOptionalByCourseId(Long courseId);

    Course findByCourseId(Long courseId);
}
