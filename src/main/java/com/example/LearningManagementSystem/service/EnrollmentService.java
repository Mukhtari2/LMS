package com.example.LearningManagementSystem.service;

import com.example.LearningManagementSystem.dto.EnrollmentRequestDto;
import com.example.LearningManagementSystem.dto.EnrollmentResponseDto;

import java.util.List;

public interface EnrollmentService {
    EnrollmentResponseDto enrollPublishedCourse(EnrollmentRequestDto request);
    List<EnrollmentResponseDto> viewAllEnrolledCourses();
}
