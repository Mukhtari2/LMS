package com.example.LearningManagementSystem.dto;

import lombok.*;

import java.util.Date;

@Setter
@Getter
@ToString
@RequiredArgsConstructor
public class SubmissionResponseDTO {

    private Long id;

    private Long assignmentId;

    private Long studentId;

    private String fileUrl;

    private String answeredAt;

    private Integer grade;

    private String feedback;

    private Date submittedAt;

}
