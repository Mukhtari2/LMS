package com.example.LearningManagementSystem.service;

import com.example.LearningManagementSystem.repository.SubmissionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ActiveProfiles("test")
class SubmissionServiceImplTest {

    @Autowired
    private SubmissionService submissionService;

    @Autowired
    private SubmissionRepository submissionRepository;

    @BeforeEach
    void setUp() {
        submissionRepository.deleteAll();
    }

    @Test
    void submitAnswers() {
    }

    @Test
    void viewSubmission() {
    }

    @Test
    void viewAllSubmission() {
    }
}