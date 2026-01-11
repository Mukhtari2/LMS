package com.example.LearningManagementSystem.dto;


import lombok.*;

@Setter
@Getter
@ToString
@RequiredArgsConstructor
public class EnrollmentRequestDTO {

    private Long studentId;

    private Long courseId;

}

