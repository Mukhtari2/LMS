package com.example.LearningManagementSystem.service;

import com.example.LearningManagementSystem.dto.AssignmentRequestDTO;
import com.example.LearningManagementSystem.dto.AssignmentResponseDTO;
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
        AssignmentRequestDTO assignment = AssignmentRequestDTO.builder()
                .title("measurement calculation")
                .description("physical health education")
                .dueDate(LocalDate.of(2026,4,23))
                .courseId(course.getId())
                .build();
        AssignmentResponseDTO responseDTO = assignmentService.createAssignment(assignment);
        assertNotNull(responseDTO);
    }

    @Test
    void viewAssignmentByCourseId() {
        String id = "6544L";
        Assignment courseId = new Assignment();
        courseId.setId(id);
        assignmentRepository.save(courseId);
        AssignmentRequestDTO assignment = AssignmentRequestDTO.builder()
                .title("measurement calculation")
                .description("physical health education")
                .dueDate(LocalDate.of(2026,4,23))
                .courseId(courseId.getId())
                .build();
        AssignmentResponseDTO view = assignmentService.viewAssignment(assignment.getCourseId());
        assertNotNull(view);
        assertEquals("measurement calculation", view.getTitle());
        assertEquals(courseId.getId(), view.getCourseId());
        assertEquals(LocalDate.of(2026,4,23), view.getDueDate());

    }
    @Test
    void findByAssignmentId() {
    }
}