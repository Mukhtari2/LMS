package com.example.LearningManagementSystem.service;

import com.example.LearningManagementSystem.Exception.ResourceNotFoundException;
import com.example.LearningManagementSystem.dto.LessonRequestDTO;
import com.example.LearningManagementSystem.dto.LessonResponseDTO;
import com.example.LearningManagementSystem.mapper.LessonMapper;
import com.example.LearningManagementSystem.model.Lesson;
import com.example.LearningManagementSystem.repository.LessonRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class LessonServiceImpl implements LessonService{

    private final CourseService courseService;
    private final LessonRepository lessonRepository;
    private final LessonMapper lessonMapper;


    @Override
    public LessonResponseDTO addLesson(LessonRequestDTO request) {
        return Optional.ofNullable(courseService.findByCourseId(request.getCourseId()))
                .map(course -> lessonMapper.toEntity(request, course))
                .map(lessonRepository::insert)
                .map(lessonMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("No course Id available for adding lesson"));
    }

    @Override
    public LessonResponseDTO viewLesson(String courseId) {
        Lesson lesson = lessonRepository.findByCourseId(courseId).orElseThrow(() -> new ResourceNotFoundException
                ("No lesson found with id " + courseId));
        return lessonMapper.toDto(lesson);
    }

    @Override
    public List<LessonResponseDTO> viewAllLessons (){
        return lessonRepository.findAll().stream().map(lessonMapper::toDto).toList();
    }

}

