package com.example.LearningManagementSystem.service;

import com.example.LearningManagementSystem.dto.AssignmentRequestDto;
import com.example.LearningManagementSystem.dto.AssignmentResponseDto;
import com.example.LearningManagementSystem.model.Assignment;
import com.example.LearningManagementSystem.model.Course;
import com.example.LearningManagementSystem.repository.AssignmentRepository;
import com.example.LearningManagementSystem.repository.CourseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class AssignmentServiceImplTest {

    @Autowired
    private AssignmentService assignmentService;

    @Autowired
    private AssignmentRepository assignmentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @BeforeEach
    void setUp() {
        courseRepository.deleteAll();
        assignmentRepository.deleteAll();
    }

    @Test
    void createAssignment() {
        String courseId = "6544L";
        Course course = new Course();
        course.setId(courseId);
        courseRepository.save(course);

        AssignmentRequestDto assignment = AssignmentRequestDto.builder()
                .title("measurement calculation")
                .description("physical health education")
                .dueDate(LocalDate.of(2026,4,23))
                .courseId(course.getId())
                .build();
        AssignmentResponseDto responseDTO = assignmentService.createAssignment(assignment);
        assertNotNull(responseDTO);
        assertEquals("physical health education", responseDTO.getDescription());
    }

    @Test
    void viewAssignmentByCourseId() {
        String courseId = "64L";
        Course course = new Course();
        course.setId(courseId);
        courseRepository.save(course);

        AssignmentRequestDto assignment = AssignmentRequestDto.builder()
                .title("measurement calculation")
                .description("physical health education")
                .dueDate(LocalDate.of(2026,4,23))
                .courseId(course.getId())
                .build();
        assignmentService.createAssignment(assignment);
        AssignmentResponseDto view = assignmentService.viewAssignment(assignment.getCourseId());
        assertNotNull(view);
        assertEquals(course.getId(), view.getCourseId());
        assertEquals(LocalDate.of(2026,4,23), view.getDueDate());

    }
    @Test
    void findByAssignmentId() {
        String assignmentId = "64L";
        Assignment assignment = Assignment.builder()
                .id(assignmentId)
                .courseId("21L")
                .title("Optics and Sciences")
                .build();
        assignmentRepository.save(assignment);

        Assignment findAssignment = assignmentService.findByAssignmentId(assignment.getId());
        assertNotNull(findAssignment);

    }
}