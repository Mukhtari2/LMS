package com.example.LearningManagementSystem.service;

import com.example.LearningManagementSystem.dto.SubmissionRequestDTO;
import com.example.LearningManagementSystem.dto.SubmissionResponseDTO;
import com.example.LearningManagementSystem.model.Submission;

import java.util.Optional;

public interface SubmissionService {

    SubmissionResponseDTO submitAnswers(SubmissionRequestDTO requestDTO);
}
