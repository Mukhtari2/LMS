package com.example.LearningManagementSystem.dto;

import com.example.LearningManagementSystem.model.Assignment;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class SubmissionResponseDTO {
    private Long id;
    private Long assignmentId;
    private Long studentId;
    private String fileUrl;
    private String answeredAt;
    private Integer grade;
    private String feedback;
}
