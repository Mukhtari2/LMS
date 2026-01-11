package com.example.LearningManagementSystem.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "assignments")
public class Assignment {
    @Id
    private String id;

    private Course course;

    private String title;

    private String description;

    private Date dueDate;

}
