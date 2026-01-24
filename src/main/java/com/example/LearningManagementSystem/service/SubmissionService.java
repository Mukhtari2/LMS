package com.example.LearningManagementSystem.service;

import com.example.LearningManagementSystem.dto.SubmissionRequestDTO;
import com.example.LearningManagementSystem.dto.SubmissionResponseDTO;

import java.util.List;

public interface SubmissionService {

    SubmissionResponseDTO submitAnswers(SubmissionRequestDTO requestDTO);
    SubmissionResponseDTO viewSubmission(String submissionId);
    List<SubmissionResponseDTO> viewAllSubmissions();
}
