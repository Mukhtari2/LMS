package com.example.LearningManagementSystem.Service;

import com.example.LearningManagementSystem.Dto.CourseRequestDTO;
import com.example.LearningManagementSystem.Dto.CourseResponseDTO;
import com.example.LearningManagementSystem.Model.Course;
import com.example.LearningManagementSystem.Repository.CourseRepository;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService{

    private CourseRepository repository;
    private CourseMapper courseMapper;


    @Override
    public CourseResponseDTO createCourse(CourseRequestDTO requestDTO) {
        Course course = Course.builder()
                .status(requestDTO.getStatus())
                .description(requestDTO.getDescription())
                .tittle(requestDTO.getTittle())
                .teacherId(requestDTO.getTeacherId())
                .build();
        Course newCourse = repository.save(course);
        return courseMapper.toDto(newCourse);
    }

    @Override
    public Course updateCourse() {
        return null;
    }
}
