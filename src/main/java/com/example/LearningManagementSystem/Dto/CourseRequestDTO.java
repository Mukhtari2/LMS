package com.example.LearningManagementSystem.Dto;

import com.example.LearningManagementSystem.Enum.Status;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CourseRequestDTO {
    private Long id;
    private String tittle;
    private String description;
    private Status status;
    private Long teacherId;
}
