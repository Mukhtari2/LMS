package com.example.LearningManagementSystem.service;

import com.example.LearningManagementSystem.Enum.Role;
import com.example.LearningManagementSystem.Enum.Status;
import com.example.LearningManagementSystem.dto.CourseRequestDto;
import com.example.LearningManagementSystem.dto.CourseResponseDto;
import com.example.LearningManagementSystem.model.Course;
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
        CourseRequestDto newCourse = new CourseRequestDto();
        newCourse.setDescription("Agro_Engineering");
        newCourse.setRole(Role.TEACHER);
        newCourse.setTitle("AGR101");
        newCourse.setTeacherId("12C");
        newCourse.setStatus(Status.DRAFT);

        assertEquals(0, courseRepository.count());
        CourseResponseDto registerCourse = courseService.registerCourse(newCourse);
        assertEquals(1, courseRepository.count());

        assertNotNull(registerCourse);
        assertEquals("12C", newCourse.getTeacherId());
    }

    @Test
    void findByCourseId() {
        CourseRequestDto request = new CourseRequestDto();
        request.setTitle("GEO@121");
        request.setTeacherId("G120");
        CourseResponseDto savedCourse = courseService.registerCourse(request);

        Course foundCourse = courseService.findByCourseId(savedCourse.getId());
        assertNotNull(foundCourse);
        assertEquals("GEO@121", foundCourse.getTitle());
    }

    @Test
    void updateCourse() {
        CourseRequestDto request = new CourseRequestDto();
        request.setTitle("Old Title");
        request.setStatus(Status.DRAFT);
        CourseResponseDto savedCourse = courseService.registerCourse(request);

        CourseRequestDto updateRequest = new CourseRequestDto();
        updateRequest.setTitle("New Updated Title");
        updateRequest.setStatus(Status.PUBLISH);

        assertEquals(1, courseRepository.count());
        CourseResponseDto updatedCourse = courseService.updateCourse(savedCourse.getId(), updateRequest);
        assertNotNull(updatedCourse);
        assertEquals("New Updated Title", updatedCourse.getTitle());
        assertEquals(Status.PUBLISH, updatedCourse.getStatus());
        assertEquals(1, courseRepository.count());
    }
}