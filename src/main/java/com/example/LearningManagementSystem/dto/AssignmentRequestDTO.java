package com.example.LearningManagementSystem.dto;
import com.example.LearningManagementSystem.model.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class AssignmentRequestDTO {
    private Long id;
    private Long courseId;
    private String title;
    private String description;
    private Date dueDate;
}
