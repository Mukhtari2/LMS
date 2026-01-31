package com.example.LearningManagementSystem.service;

import com.example.LearningManagementSystem.Exception.ResourceNotFoundException;
import com.example.LearningManagementSystem.dto.CourseRequestDto;
import com.example.LearningManagementSystem.dto.CourseResponseDto;
import com.example.LearningManagementSystem.mapper.CourseMapper;
import com.example.LearningManagementSystem.model.Course;
import com.example.LearningManagementSystem.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService{

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    @Override
    public CourseResponseDto registerCourse(CourseRequestDto requestDTO) {
        Course course = Course.builder()
                .status(requestDTO.getStatus())
                .description(requestDTO.getDescription())
                .title(requestDTO.getTitle())
                .teacherId(requestDTO.getTeacherId())
                .build();
        Course newCourse = courseRepository.insert(course);
        return courseMapper.toDto(newCourse);
    }

    @Override
    public Course findByCourseId(String courseId) {
        return courseRepository.findById(courseId).orElseThrow();
    }

    @Override
    public CourseResponseDto updateCourse(String courseId, CourseRequestDto requestDTO) {
       Course existingCourse = courseRepository.findById(courseId).orElseThrow(()-> new ResourceNotFoundException("No course found with the Id " + courseId));
           courseMapper.updateEntityFromDto(requestDTO, existingCourse);
           Course updatedCourse = courseRepository.save(existingCourse);
           return courseMapper.toDto(updatedCourse);
    }

    @Override
    public List<CourseResponseDto> viewAllCreatedCourses() {
        return courseRepository.findAll().stream().map(courseMapper::toDto).toList();
    }
}
