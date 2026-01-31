package com.example.LearningManagementSystem.model;

import com.example.LearningManagementSystem.Enum.Role;
import com.example.LearningManagementSystem.Enum.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "courses")
public class Course extends BaseAuditEntity {
    @Id
    private String id;

    @NotBlank(message = "Course title cannot be empty")
    @Size(min = 5, max = 100, message = "Title must be between 5 and 100 characters")
    @Indexed
    private String title;

    @NotBlank(message = "Description is required")
    @Size(min = 10, message = "Description should be detailed (min 10 chars)")
    private String description;

    @NotBlank(message = "Teacher ID must be assigned")
    @Indexed
    private String teacherId;

    @NotNull(message = "Status is required")
    private Status status;

}
