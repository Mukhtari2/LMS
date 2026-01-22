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
import java.util.List;

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
        assignmentRepository.deleteAll();
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
        request.setGrade(22);
        request.setFeedback("Very Poor");

        SubmissionResponseDTO newSubmission = submissionService.submitAnswers(request);
        assertNotNull(newSubmission);
        assertEquals(Grade.FAIL, newSubmission.getGrade());
    }

    @Test
    void viewSubmission() {
        String assignmentId = "8776/8/LP";
        Assignment assignment = new Assignment();
        assignment.setId(assignmentId);
        assignmentRepository.save(assignment);

        SubmissionRequestDTO request = new SubmissionRequestDTO();
        request.setAssignmentId(assignmentId);
        request.setAnsweredAt(LocalDateTime.now());
        request.setStudentId("4482/MN");
        request.setGrade(22);
        request.setFeedback("Very Poor");

        SubmissionResponseDTO saved = submissionService.submitAnswers(request);

        SubmissionResponseDTO result = submissionService.viewSubmission(saved.getId());

        assertNotNull(result);
        assertEquals(saved.getId(), result.getId());
        assertEquals("4482/MN", result.getStudentId());
    }

    @Test
    void viewAllSubmission() {
        String assignmentId = "GEL224";
        Assignment assignment = new Assignment();
        assignment.setId(assignmentId);
        assignmentRepository.save(assignment);

        String assignmentId2 = "GEL215";
        Assignment assignment2 = new Assignment();
        assignment2.setId(assignmentId2);
        assignmentRepository.save(assignment2);

        SubmissionRequestDTO request = new SubmissionRequestDTO();
        request.setAssignmentId(assignmentId);
        request.setAnsweredAt(LocalDateTime.now());
        request.setStudentId("4482/MN");
        request.setGrade(22);
        request.setFeedback("Very Poor");
        submissionService.submitAnswers(request);

        SubmissionRequestDTO request2 = new SubmissionRequestDTO();
        request2.setAssignmentId(assignmentId2);
        request2.setAnsweredAt(LocalDateTime.now());
        request2.setStudentId("4482/MN");
        request2.setGrade(22);
        request2.setFeedback("Very Poor");
        submissionService.submitAnswers(request2);

        List<SubmissionResponseDTO> submissions = submissionService.viewAllSubmission();

        assertNotNull(submissions);
        assertEquals(2, submissions.size());
    }
}