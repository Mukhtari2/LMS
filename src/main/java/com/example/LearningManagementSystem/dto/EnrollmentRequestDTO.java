package com.example.LearningManagementSystem.dto;


import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class EnrollmentRequestDTO {
    private Long studentId;
    private Long courseId;
}

