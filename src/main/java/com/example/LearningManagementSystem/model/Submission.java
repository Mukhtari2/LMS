package com.example.LearningManagementSystem.model;

import com.example.LearningManagementSystem.Enum.Grade;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "submissions")
public class Submission {

   @Id
    private String id;

    @NotBlank(message = "Assignment ID is required")
    @Indexed
    private String assignment;

    @NotBlank(message = "Student ID is required")
    @Indexed
    private String studentId;

    @NotBlank(message = "File URL is required")
    @Pattern(regexp = "^https?://.*$", message = "Must be a valid secure URL")
    private String fileUrl;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "d/M/yyyy")
    private LocalDate answeredAt;

    private Grade grade;

    @Size(max = 1000, message = "Feedback is too long")
    private String feedback;

    @NotNull(message = "Submission date is required")
    @PastOrPresent(message = "Submission date cannot be in the future")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "d/M/yyyy")
    @CreatedDate
    private LocalDate submittedAt;

}
