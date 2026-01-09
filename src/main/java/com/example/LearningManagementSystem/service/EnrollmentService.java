package com.example.LearningManagementSystem.service;

import com.example.LearningManagementSystem.dto.EnrollmentRequestDTO;
import com.example.LearningManagementSystem.dto.EnrollmentResponseDTO;
import com.example.LearningManagementSystem.model.Enrollment;

import java.util.List;

public interface EnrollmentService {
    EnrollmentResponseDTO enrollPublishedCourse(EnrollmentRequestDTO request);
    List<Enrollment> viewAllEnrolledCourses();
}
