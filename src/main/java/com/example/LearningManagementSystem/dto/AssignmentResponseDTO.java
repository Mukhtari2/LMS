package com.example.LearningManagementSystem.dto;

import com.example.LearningManagementSystem.model.Course;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@ToString
@RequiredArgsConstructor
public class AssignmentResponseDTO {

    private Long id;

    private Long courseId;

    private String title;

    private String description;

    private Date dueDate;

}
