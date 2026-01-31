package com.example.LearningManagementSystem.service;

import com.example.LearningManagementSystem.Enum.Status;
import com.example.LearningManagementSystem.dto.EnrollmentRequestDto;
import com.example.LearningManagementSystem.dto.EnrollmentResponseDto;
import com.example.LearningManagementSystem.model.Course;
import com.example.LearningManagementSystem.repository.CourseRepository;
import com.example.LearningManagementSystem.repository.EnrollmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

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
        courseRepository.deleteAll();
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

        EnrollmentRequestDto request = new EnrollmentRequestDto();
        request.setCourseId(newCourse.getId() );
        request.setStudentId("2015/1/57125PL");

        EnrollmentResponseDto response = enrollmentService.enrollPublishedCourse(request);

        assertNotNull(response);
        assertEquals(courseId, response.getCourseId());
        assertEquals("Advanced Petroleum Geology", newCourse.getTitle());
        assertEquals("2015/1/57125PL", response.getStudentId());


        assertEquals(1, enrollmentRepository.count());

    }

    @Test
    void viewAllEnrolledCourses() {
        String courseId = "GEL523";
        Course courseA = new Course();
        courseA.setId(courseId);
        courseA.setTitle("Advanced HydroGeology");
        courseA.setTeacherId("65NA");
        courseA.setStatus(Status.DRAFT);
        Course course1 = courseRepository.save(courseA);

        String courseId2 = "GEL312";
        Course courseB = new Course();
        courseB.setId(courseId2);
        courseB.setTitle("Advanced HydroGeology");
        courseB.setTeacherId("65NA");
        courseB.setStatus(Status.DRAFT);
        Course course2 = courseRepository.save(courseB);

        EnrollmentRequestDto enrollmentRequest = new EnrollmentRequestDto();
        enrollmentRequest.setCourseId(course1.getId());
        enrollmentRequest.setStudentId("2015/1/57654PL");
        enrollmentService.enrollPublishedCourse(enrollmentRequest);

        EnrollmentRequestDto enrollmentRequest2 = new EnrollmentRequestDto();
        enrollmentRequest2.setCourseId(course2.getId());
        enrollmentRequest2.setStudentId("2015/1/52112PL");
        enrollmentService.enrollPublishedCourse(enrollmentRequest2);

        List<EnrollmentResponseDto> allCourses = enrollmentService.viewAllEnrolledCourses();
        assertNotNull(allCourses);
        assertEquals("2015/1/52112PL", allCourses.get(1).getStudentId() );
    }
}