package com.example.LearningManagementSystem.service;

import com.example.LearningManagementSystem.dto.SubmissionRequestDTO;
import com.example.LearningManagementSystem.dto.SubmissionResponseDTO;
import com.example.LearningManagementSystem.model.Assignment;
import com.example.LearningManagementSystem.model.Submission;

public interface SubmissionService {
    SubmissionResponseDTO submitAnswers(SubmissionRequestDTO requestDTO);
}
