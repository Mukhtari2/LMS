package com.example.LearningManagementSystem.service;

import com.example.LearningManagementSystem.Enum.Grade;
import com.example.LearningManagementSystem.dto.AssignmentRequestDTO;
import com.example.LearningManagementSystem.dto.AssignmentResponseDTO;
import com.example.LearningManagementSystem.dto.SubmissionRequestDTO;
import com.example.LearningManagementSystem.dto.SubmissionResponseDTO;
import com.example.LearningManagementSystem.model.Assignment;
import com.example.LearningManagementSystem.repository.AssignmentRepository;
import com.example.LearningManagementSystem.repository.SubmissionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.Date;

import static com.example.LearningManagementSystem.Enum.Grade.FAIL;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ActiveProfiles("test")
class SubmissionServiceImplTest {

    @Autowired
    private SubmissionService submissionService;

    @Autowired
    private SubmissionRepository submissionRepository;

    @Autowired
    private AssignmentService assignmentService;

    @Autowired
    private AssignmentRepository assignmentRepository;

    @BeforeEach
    void setUp() {
        submissionRepository.deleteAll();
    }

    @Test
    void submitAnswers() {
        String assignmentId = "1234LM";
        Assignment assignment = new Assignment();
        assignment.setId(assignmentId);
        assignmentRepository.save(assignment);

        SubmissionRequestDTO request = new SubmissionRequestDTO();
        request.setAssignmentId(assignmentId);
        request.setAnsweredAt(LocalDateTime.now());
        request.setStudentId("1222/2/111PL");
        request.setGrade(2);
        request.setFeedback("Very Poor");

        SubmissionResponseDTO newSubmission = submissionService.submitAnswers(request);
        assertNotNull(newSubmission);
        assertEquals(FAIL, newSubmission.getGrade());
    }

    @Test
    void viewSubmission() {
    }

    @Test
    void viewAllSubmission() {
    }
}