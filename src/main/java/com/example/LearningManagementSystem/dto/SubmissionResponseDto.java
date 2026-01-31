package com.example.LearningManagementSystem.dto;

import com.example.LearningManagementSystem.Enum.Grade;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@ToString
@RequiredArgsConstructor
public class SubmissionResponseDto {

    private String id;

    private String assignmentId;

    private String studentId;

    private String fileUrl;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "d/M/yyyy")
    private LocalDate answeredAt;

    private Grade grade;

    private String feedback;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "d/M/yyyy")
    private LocalDate submittedAt;

}
