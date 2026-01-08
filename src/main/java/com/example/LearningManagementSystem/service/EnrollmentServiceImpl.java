package com.example.LearningManagementSystem.service;

import com.example.LearningManagementSystem.dto.EnrollmentRequestDTO;
import com.example.LearningManagementSystem.dto.EnrollmentResponseDTO;
import com.example.LearningManagementSystem.mapper.EnrollmentMapper;
import com.example.LearningManagementSystem.model.Course;
import com.example.LearningManagementSystem.model.Enrollment;
import com.example.LearningManagementSystem.repository.EnrollmentRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnrollmentServiceImpl implements EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final EnrollmentMapper enrollmentMapper;
    private final CourseService courseService;

    @PreAuthorize("hasRole('STUDENT')")
    @Override
    public EnrollmentResponseDTO enrollPublishedCourse(EnrollmentRequestDTO request) {
        Course course = courseService.findByCourseId(request.getCourseId());
        if (course != null) {
            Enrollment enroll = enrollmentMapper.toEntity(request, course);
            Enrollment savedEnrollment = enrollmentRepository.save(enroll);
            return enrollmentMapper.toDto(savedEnrollment);
        } else throw new EntityNotFoundException("Course with ID " + request.getCourseId());
    }

    @Override
    public List<Enrollment> viewAllEnrolledCourses() {
        return List.of();
    }
}
