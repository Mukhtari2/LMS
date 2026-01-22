package com.example.LearningManagementSystem.dto;

import com.example.LearningManagementSystem.Enum.Grade;
import com.example.LearningManagementSystem.model.Assignment;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Setter
@Getter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class SubmissionRequestDTO {

    private String assignmentId;

    private String studentId;

    private String fileUrl;

    private LocalDateTime answeredAt;

    private int grade;

    private String feedback;

    private LocalDateTime submittedAt;
}
