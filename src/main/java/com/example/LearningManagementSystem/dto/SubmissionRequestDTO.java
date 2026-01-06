package com.example.LearningManagementSystem.dto;

import com.example.LearningManagementSystem.model.Assignment;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class SubmissionRequestDTO {
    private Long id;
    private Assignment assignmentId;
    private Long studentId;
    private String fileUrl;
    private String answeredAt;
    private Integer grade;
    private String feedback;
}
