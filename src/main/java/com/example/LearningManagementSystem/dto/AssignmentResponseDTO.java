package com.example.LearningManagementSystem.dto;

import com.example.LearningManagementSystem.model.Course;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@RequiredArgsConstructor
public class AssignmentResponseDTO {
    private Long id;
    private Long courseId;
    private String title;
    private String description;
    private Date dueDate;
}
