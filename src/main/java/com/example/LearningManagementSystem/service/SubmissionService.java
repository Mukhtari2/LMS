package com.example.LearningManagementSystem.service;

import com.example.LearningManagementSystem.dto.SubmissionRequestDto;
import com.example.LearningManagementSystem.dto.SubmissionResponseDto;

import java.util.List;

public interface SubmissionService {

    SubmissionResponseDto submitAnswers(SubmissionRequestDto requestDTO);
    SubmissionResponseDto viewSubmission(String submissionId);
    List<SubmissionResponseDto> viewAllSubmissions();
}
