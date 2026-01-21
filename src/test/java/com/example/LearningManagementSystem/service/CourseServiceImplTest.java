package com.example.LearningManagementSystem.service;

import com.example.LearningManagementSystem.repository.CourseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ActiveProfiles("test")
class CourseServiceImplTest {

    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseRepository courseRepository;


    @BeforeEach
    void setUp() {
        courseRepository.deleteAll();
    }

    @Test
    void registerCourse() {
    }

    @Test
    void findByCourseId() {
    }

    @Test
    void updateCourse() {
    }
}