package com.example.LearningManagementSystem.service;

import com.example.LearningManagementSystem.dto.CourseRequestDto;
import com.example.LearningManagementSystem.dto.CourseResponseDto;
import com.example.LearningManagementSystem.model.Course;

import java.util.List;

public interface CourseService {
    CourseResponseDto registerCourse(CourseRequestDto requestDTO);

    CourseResponseDto updateCourse(String courseId, CourseRequestDto requestDTO);

    Course findByCourseId(String courseId);

    List<CourseResponseDto> viewAllCreatedCourses();
}
