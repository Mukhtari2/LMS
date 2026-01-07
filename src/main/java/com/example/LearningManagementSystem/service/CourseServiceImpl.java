package com.example.LearningManagementSystem.service;

import com.example.LearningManagementSystem.dto.CourseRequestDTO;
import com.example.LearningManagementSystem.dto.CourseResponseDTO;
import com.example.LearningManagementSystem.mapper.CourseMapper;
import com.example.LearningManagementSystem.model.Course;
import com.example.LearningManagementSystem.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService{

    private final CourseRepository repository;
    private CourseMapper courseMapper;

    @Override
    public CourseResponseDTO registerCourse(CourseRequestDTO requestDTO) {
        Course course = Course.builder()
                .status(requestDTO.getStatus())
                .description(requestDTO.getDescription())
                .title(requestDTO.getTitle())
                .teacherId(requestDTO.getTeacherId())
                .build();
        Course newCourse = repository.save(course);
        return courseMapper.toDto(newCourse);
    }

    @Override
    public Course findByCourseId(Long courseId) {
        return repository.findById(courseId).orElseThrow();
    }

    @Override
    public Course updateCourse() {
        return null;
    }

    @Override
    public Optional<Course> findOptionalByCourseId(Long courseId) {
        return repository.findById(courseId);
    }
}
