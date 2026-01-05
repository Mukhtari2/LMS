package com.example.LearningManagementSystem.Dto;

import com.example.LearningManagementSystem.Model.Assignment;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class SubmissionResponseDTO {
    private Long id;
    private Assignment assignmentId;
    private Long studentId;
    private String fileUrl;
    private String answeredAt;
    private Integer grade;
    private String feedback;
}
