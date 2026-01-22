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
        String lessonId = "8891ML";
        Lesson lesson = new Lesson();
        lesson.setId(lessonId);
        Lesson newLesson = lessonRepository.save(lesson);

        LessonRequestDTO lesson1 = new LessonRequestDTO();
        lesson1.setCourseId(newLesson.getId());
        lesson1.setTitle("Hydrology");
        lesson1.setContentUrl("https://www.geoworldd.com");
        lessonService.addLesson(lesson1);

//        String courseIdB = "AL900";
//        Course courseB = new Course();
//        courseB.setId(courseIdB);
//        Course savedCourseB = courseRepository.save(courseB);
//        LessonRequestDTO lesson2 = new LessonRequestDTO();
//        lesson2.setCourseId(savedCourseB.getId());
//        lesson2.setTitle("Aquifer Properties");
//        lesson2.setContentUrl("http://example.com/lesson2");
//        lessonService.addLesson(lesson2);

        LessonResponseDTO savedLessons = lessonService.viewLesson(lesson1.getCourseId());
//        LessonResponseDTO savedLessons = lessonService.viewLesson(lesson2.getCourseId());
        assertNotNull(savedLessons);
    }
}