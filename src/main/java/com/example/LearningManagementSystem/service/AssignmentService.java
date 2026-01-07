package com.example.LearningManagementSystem.service;

import com.example.LearningManagementSystem.dto.AssignmentRequestDTO;
import com.example.LearningManagementSystem.dto.AssignmentResponseDTO;
import com.example.LearningManagementSystem.model.Assignment;


public interface AssignmentService {
    AssignmentResponseDTO viewAssignment(AssignmentRequestDTO requestDTO);
    AssignmentResponseDTO submitAssignment(AssignmentRequestDTO requestDTO);
    Assignment findByAssignmentId(Long assignmentId);

}
