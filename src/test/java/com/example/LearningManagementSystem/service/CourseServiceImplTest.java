package com.example.LearningManagementSystem.service;

import com.example.LearningManagementSystem.Enum.Role;
import com.example.LearningManagementSystem.Enum.Status;
import com.example.LearningManagementSystem.dto.CourseRequestDTO;
import com.example.LearningManagementSystem.dto.CourseResponseDTO;
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
        CourseRequestDTO newCourse = new CourseRequestDTO();
        newCourse.setDescription("Agro_Engineering");
        newCourse.setRole(Role.TEACHER);
        newCourse.setTitle("AGR101");
        newCourse.setTeacherId("12C");
        newCourse.setStatus(Status.DRAFT);

        assertEquals(0, courseRepository.findAll().size());
        CourseResponseDTO registerCourse = courseService.registerCourse(newCourse);
        assertEquals(1, courseRepository.findAll().size());

        assertNotNull(registerCourse);
        assertEquals("12C", newCourse.getTeacherId());
    }

    @Test
    void findByCourseId() {
        CourseRequestDTO request = new CourseRequestDTO();
        request.setTitle("GEO@121");
        request.setTeacherId("G120");
        CourseResponseDTO savedCourse = courseService.registerCourse(request);

        Course foundCourse = courseService.findByCourseId(savedCourse.getId());
        assertNotNull(foundCourse);
        assertEquals("GEO@121", foundCourse.getTitle());
    }

    @Test
    void updateCourse() {
        CourseRequestDTO request = new CourseRequestDTO();
        request.setTitle("Old Title");
        request.setStatus(Status.DRAFT);
        CourseResponseDTO savedCourse = courseService.registerCourse(request);

        CourseRequestDTO updateRequest = new CourseRequestDTO();
        updateRequest.setTitle("New Updated Title");
        updateRequest.setStatus(Status.PUBLISH);

        assertEquals(0, courseRepository.findAll().size());
        CourseResponseDTO updatedCourse = courseService.updateCourse(savedCourse.getId(), updateRequest);
        assertNotNull(updatedCourse);
        assertEquals("New Updated Title", updatedCourse.getTitle());
        assertEquals(Status.PUBLISH, updatedCourse.getStatus());
        assertEquals(1, courseRepository.findAll().size());
    }
}