package com.example.LearningManagementSystem.service;

import com.example.LearningManagementSystem.repository.LessonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class LessonServiceImplTest {

    @Autowired
    private LessonService lessonService;

    @Autowired
    private LessonRepository lessonRepository;

    @BeforeEach
    void setUp() {
        lessonRepository.deleteAll();
    }

    @Test
    void addLesson() {
    }

    @Test
    void viewLesson() {
    }
}