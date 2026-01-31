package com.example.LearningManagementSystem.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class SubmissionRequestDto {

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
