package com.example.LearningManagementSystem.service;

import com.example.LearningManagementSystem.repository.AssignmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class AssignmentServiceImplTest {

    @Autowired
    private AssignmentService assignmentService;

    @Autowired
    private AssignmentRepository assignmentRepository;

    @BeforeEach
    void setUp() {
        assignmentRepository.deleteAll();
    }

    @Test
    void viewAssignment() {
    }

    @Test
    void createAssignment() {
    }

    @Test
    void findByAssignmentId() {
    }
}