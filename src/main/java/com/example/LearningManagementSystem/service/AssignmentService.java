package com.example.LearningManagementSystem.service;

import com.example.LearningManagementSystem.dto.AssignmentRequestDTO;
import com.example.LearningManagementSystem.dto.AssignmentResponseDTO;
import com.example.LearningManagementSystem.model.Assignment;


public interface AssignmentService {
    AssignmentResponseDTO viewAssignment(String courseId);
    AssignmentResponseDTO createAssignment(AssignmentRequestDTO requestDTO);
    Assignment findByAssignmentId(String assignmentId);

}
