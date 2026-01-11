package com.example.LearningManagementSystem.service;

import com.example.LearningManagementSystem.Exception.ResourceNotFoundException;
import com.example.LearningManagementSystem.dto.LessonRequestDTO;
import com.example.LearningManagementSystem.dto.LessonResponseDTO;
import com.example.LearningManagementSystem.mapper.LessonMapper;
import com.example.LearningManagementSystem.model.Course;
import com.example.LearningManagementSystem.model.Lesson;
import com.example.LearningManagementSystem.repository.LessonRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.nio.file.ReadOnlyFileSystemException;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class LessonServiceImpl implements LessonService{

    private final CourseService courseService;
    private final LessonRepository repository;
    private final LessonMapper lessonMapper;

    @PreAuthorize("hasRole('TEACHER')")
    @Override
    public LessonResponseDTO addLesson(LessonRequestDTO request) {
//        Course course = courseService.findByCourseId(request.getCourseId());
//        if (course != null) {
//            Lesson newLesson = lessonMapper.toEntity(request, course);
//            Lesson savedLesson = repository.insert(newLesson);
//            return lessonMapper.toDto(savedLesson);
//        }else throw new ResourceNotFoundException("No course Id available for adding lessson");


        return Optional.ofNullable(courseService.findByCourseId(request.getCourseId()))
                .map(course -> lessonMapper.toEntity(request, course))
                .map(repository::insert)
                .map(lessonMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("No course Id available for adding lesson"));

    }
}

