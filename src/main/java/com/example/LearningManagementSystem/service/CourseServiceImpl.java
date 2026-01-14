package com.example.LearningManagementSystem.service;

import com.example.LearningManagementSystem.Enum.Role;
import com.example.LearningManagementSystem.dto.CourseRequestDTO;
import com.example.LearningManagementSystem.dto.CourseResponseDTO;
import com.example.LearningManagementSystem.mapper.CourseMapper;
import com.example.LearningManagementSystem.model.Course;
import com.example.LearningManagementSystem.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService{

    private final CourseRepository repository;
    private final CourseMapper courseMapper;

    @PreAuthorize("hasRole('TEACHER')")
    @Override
    public CourseResponseDTO registerCourse(CourseRequestDTO requestDTO) {
        Course course = Course.builder()
                .status(requestDTO.getStatus())
                .description(requestDTO.getDescription())
                .title(requestDTO.getTitle())
                .teacherId(requestDTO.getTeacherId())
                .role(Role.TEACHER)
                .build();
        Course newCourse = repository.insert(course);
        return courseMapper.toDto(newCourse);
    }

    @Override
    public Course findByCourseId(String courseId) {
        return repository.findById(courseId).orElseThrow();
    }

    @PreAuthorize("hasRole('TEACHER')")
    @Override
    public Course updateCourse() {
        return null;
    }

    @Override
    public Optional<Course> findOptionalByCourseId(String courseId) {
        return repository.findById(courseId);
    }
}
