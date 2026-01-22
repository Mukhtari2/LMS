package com.example.LearningManagementSystem.dto;

import com.example.LearningManagementSystem.Enum.Grade;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Setter
@Getter
@ToString
@RequiredArgsConstructor
public class SubmissionResponseDTO {

    private String id;

    private String assignmentId;

    private String studentId;

    private String fileUrl;

    private LocalDateTime answeredAt;

    private Grade grade;

    private String feedback;

    private LocalDateTime submittedAt;

}
