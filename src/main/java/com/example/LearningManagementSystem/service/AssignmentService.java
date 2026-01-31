package com.example.LearningManagementSystem.service;

import com.example.LearningManagementSystem.dto.AssignmentRequestDto;
import com.example.LearningManagementSystem.dto.AssignmentResponseDto;
import com.example.LearningManagementSystem.model.Assignment;


public interface AssignmentService {
    AssignmentResponseDto viewAssignment(String courseId);
    AssignmentResponseDto createAssignment(AssignmentRequestDto requestDTO);
    Assignment findByAssignmentId(String assignmentId);

}
