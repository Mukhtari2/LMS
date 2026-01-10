package com.example.LearningManagementSystem.model;

import com.example.LearningManagementSystem.Enum.Status;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "courses")
public class Course {
    @Id
    private String id;
    private String title;
    private String description;
    private Long teacherId;
    private Status status;
}
