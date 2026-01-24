package com.example.LearningManagementSystem.service;

import com.example.LearningManagementSystem.Exception.ResourceNotFoundException;
import com.example.LearningManagementSystem.dto.EnrollmentRequestDTO;
import com.example.LearningManagementSystem.dto.EnrollmentResponseDTO;
import com.example.LearningManagementSystem.mapper.EnrollmentMapper;
import com.example.LearningManagementSystem.model.Course;
import com.example.LearningManagementSystem.model.Enrollment;
import com.example.LearningManagementSystem.repository.EnrollmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EnrollmentServiceImpl implements EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final EnrollmentMapper enrollmentMapper;
    private final CourseService courseService;


    @Override
    public EnrollmentResponseDTO enrollPublishedCourse(EnrollmentRequestDTO request) {
        return Optional.ofNullable(courseService.findByCourseId(request.getCourseId()))
                .map(courseId -> enrollmentMapper.toEntity(request, courseId))
                .map(enrollmentRepository::insert)
                .map(enrollmentMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Course with ID " + request.getCourseId()));
    }

    @Override
    public List<EnrollmentResponseDTO> viewAllEnrolledCourses() {
     return enrollmentRepository.findAll().stream().map(enrollmentMapper::toDto).toList();
    }
}
