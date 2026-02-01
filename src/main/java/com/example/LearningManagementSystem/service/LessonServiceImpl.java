package com.example.LearningManagementSystem.service;

import com.example.LearningManagementSystem.exception.ResourceNotFoundException;
import com.example.LearningManagementSystem.dto.LessonRequestDto;
import com.example.LearningManagementSystem.dto.LessonResponseDto;
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
    public LessonResponseDto addLesson(LessonRequestDto request) {
        return Optional.ofNullable(courseService.findByCourseId(request.getCourseId()))
                .map(course -> lessonMapper.toEntity(request, course))
                .map(lessonRepository::insert)
                .map(lessonMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("No course Id available for adding lesson"));
    }

    @Override
    public LessonResponseDto viewLesson(String courseId) {
        Lesson lesson = lessonRepository.findByCourseId(courseId).orElseThrow(() -> new ResourceNotFoundException
                ("No lesson found with id " + courseId));
        return lessonMapper.toDto(lesson);
    }

    @Override
    public List<LessonResponseDto> viewAllLessons (){
        return lessonRepository.findAll().stream().map(lessonMapper::toDto).toList();
    }

}

