package com.example.LearningManagementSystem.dto;
import com.example.LearningManagementSystem.model.Course;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class AssignmentRequestDTO {

    private Long courseId;

    private String title;

    private String description;

    private Date dueDate;

}
