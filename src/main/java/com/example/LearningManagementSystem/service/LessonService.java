package com.example.LearningManagementSystem.service;

import com.example.LearningManagementSystem.dto.LessonRequestDto;
import com.example.LearningManagementSystem.dto.LessonResponseDto;

import java.util.List;

public interface LessonService {
    LessonResponseDto addLesson (LessonRequestDto request);
    LessonResponseDto viewLesson (String lessonId);
    List<LessonResponseDto> viewAllLessons ();

}
