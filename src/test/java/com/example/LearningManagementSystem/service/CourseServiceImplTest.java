package com.example.LearningManagementSystem.service;

import com.example.LearningManagementSystem.Enum.Role;
import com.example.LearningManagementSystem.Enum.Status;
import com.example.LearningManagementSystem.dto.CourseRequestDTO;
import com.example.LearningManagementSystem.dto.CourseResponseDTO;
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
    }

    @Test
    void updateCourse() {
    }
}