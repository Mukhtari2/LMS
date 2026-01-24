package com.example.LearningManagementSystem.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

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

    @Indexed
    private String courseId;

    @NotBlank(message = "Assignment title is required")
    @Size(min = 3, max = 150)
    @Indexed
    private String title;

    @NotBlank(message = "Description cannot be empty")
    private String description;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "d/M/yyyy")
    private LocalDate dueDate;

}
