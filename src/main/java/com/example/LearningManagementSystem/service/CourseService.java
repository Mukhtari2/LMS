package com.example.LearningManagementSystem.service;

import com.example.LearningManagementSystem.dto.CourseRequestDTO;
import com.example.LearningManagementSystem.dto.CourseResponseDTO;
import com.example.LearningManagementSystem.model.Course;

import java.util.List;

public interface CourseService {
    CourseResponseDTO registerCourse(CourseRequestDTO requestDTO);

    CourseResponseDTO updateCourse(String courseId, CourseRequestDTO requestDTO);

    Course findByCourseId(String courseId);

    List<CourseResponseDTO> viewAllCreatedCourses();
}
