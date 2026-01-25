package com.example.LearningManagementSystem.service;

import com.example.LearningManagementSystem.dto.CourseRequestDTO;
import com.example.LearningManagementSystem.dto.LessonRequestDTO;
import com.example.LearningManagementSystem.dto.LessonResponseDTO;
import com.example.LearningManagementSystem.model.Course;
import com.example.LearningManagementSystem.model.Lesson;
import com.example.LearningManagementSystem.repository.CourseRepository;
import com.example.LearningManagementSystem.repository.LessonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class LessonServiceImplTest {

    @Autowired
    private LessonService lessonService;

    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private  CourseService courseService;

    @BeforeEach
    void setUp() {
        lessonRepository.deleteAll();
        courseRepository.deleteAll();
    }

    @Test
    void toAddLesson() {
        String courseId = "21L";
        Course courseA = new Course();
        courseA.setId(courseId);
        Course savedCourse = courseRepository.save(courseA);

        LessonRequestDTO request = new LessonRequestDTO();
        request.setCourseId(savedCourse.getId());
        request.setTitle("General lesson");
        request.setContentUrl("http://www.lesson.com");

        LessonResponseDTO newLesson = lessonService.addLesson(request);

        assertNotNull(newLesson);
        assertEquals(courseA.getId(), newLesson.getCourseId());
        assertEquals("General lesson", newLesson.getTitle());
        assertEquals("http://www.lesson.com", newLesson.getContentUrl());
    }

    @Test
    void viewLesson() {
        String courseId = "CRS-101";
        Course course = new Course();
        course.setId(courseId);
        courseRepository.save(course);

        LessonRequestDTO lesson1 = new LessonRequestDTO();
        lesson1.setCourseId(courseId);
        lesson1.setTitle("Hydrology");
        lesson1.setContentUrl("https://www.geoworldd.com");
        lessonService.addLesson(lesson1);

        LessonResponseDTO savedLessons = lessonService.viewLesson(lesson1.getCourseId());
        assertNotNull(savedLessons);
    }

    @Test
    void toViewAllLessons(){

    }
}