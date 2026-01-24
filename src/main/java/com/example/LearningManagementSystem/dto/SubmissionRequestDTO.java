package com.example.LearningManagementSystem.dto;

import com.example.LearningManagementSystem.Enum.Grade;
import com.example.LearningManagementSystem.model.Assignment;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;
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

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "d/M/yyyy")
    private LocalDate answeredAt;

    private int grade;

    private String feedback;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "d/M/yyyy")
    private LocalDate submittedAt;
}
