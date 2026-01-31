package com.example.LearningManagementSystem.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "lessons")
public class Lesson extends BaseAuditEntity {

    @Id
    private String id;

    @NotBlank(message = "Course ID is required")
    @Indexed
    private Course course;

    @NotBlank(message = "Lesson title is required")
    private String title;

    @NotBlank(message = "Content URL is required")
    @Pattern(regexp = "^(https?|ftp)://.*$", message = "Must be a valid URL")
    private String contentUrl;

}
