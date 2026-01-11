package com.example.LearningManagementSystem.dto;

import com.example.LearningManagementSystem.model.Assignment;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class SubmissionRequestDTO {

    private Long assignmentId;

    private Long studentId;

    private String fileUrl;

    private String answeredAt;

    private Integer grade;

    private String feedback;
}
