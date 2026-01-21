package com.example.LearningManagementSystem.service;

import com.example.LearningManagementSystem.Enum.Status;
import com.example.LearningManagementSystem.dto.CourseResponseDTO;
import com.example.LearningManagementSystem.dto.EnrollmentRequestDTO;
import com.example.LearningManagementSystem.dto.EnrollmentResponseDTO;
import com.example.LearningManagementSystem.model.Course;
import com.example.LearningManagementSystem.repository.CourseRepository;
import com.example.LearningManagementSystem.repository.EnrollmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class EnrollmentServiceImplTest {

    @Autowired
    private EnrollmentService enrollmentService;

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseRepository courseRepository;

    @BeforeEach
    void setUp() {
        enrollmentRepository.deleteAll();
    }

    @Test
    void toEnrollPublishedCourse() {
        String courseId = "GEL417";
        Course course = new Course();
        course.setId(courseId);
        course.setTitle("Advanced Petroleum Geology");
        course.setTeacherId("122B");
        course.setStatus(Status.PUBLISH);
        Course newCourse = courseRepository.save(course);

        EnrollmentRequestDTO request = new EnrollmentRequestDTO();
        request.setCourseId(newCourse.getId() );
        request.setStudentId("2015/1/57125PL");

        EnrollmentResponseDTO response = enrollmentService.enrollPublishedCourse(request);
        assertEquals(courseId, response.getCourseId());
        assertEquals(1, enrollmentRepository.count(), "Enrollment should be persisted in DB");

        assertNotNull(response);
    }

    @Test
    void viewAllEnrolledCourses() {
    }
}