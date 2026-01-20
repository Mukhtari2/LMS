package com.example.LearningManagementSystem.service;

import com.example.LearningManagementSystem.Enum.Role;
import com.example.LearningManagementSystem.Exception.ResourceNotFoundException;
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

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    @Override
    public CourseResponseDTO registerCourse(CourseRequestDTO requestDTO) {
        Course course = Course.builder()
                .status(requestDTO.getStatus())
                .description(requestDTO.getDescription())
                .title(requestDTO.getTitle())
                .teacherId(requestDTO.getTeacherId())
                .role(Role.TEACHER)
                .build();
        Course newCourse = courseRepository.insert(course);
        return courseMapper.toDto(newCourse);
    }

    @Override
    public Course findByCourseId(String courseId) {
        return courseRepository.findById(courseId).orElseThrow();
    }

    @Override
    public CourseResponseDTO updateCourse(String courseId, CourseRequestDTO requestDTO) {
       Course existingCourse = courseRepository.findById(courseId).orElseThrow(()-> new ResourceNotFoundException("No course found with the Id " + courseId));
           courseMapper.updateEntityFromDto(requestDTO, existingCourse);
           Course updatedCourse = courseRepository.insert(existingCourse);
           return courseMapper.toDto(updatedCourse);
    }
}
