package com.example.LearningManagementSystem.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Date;


@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "enrollments")
@CompoundIndex(name = "student_course_idx", def = "{'studentId': 1, 'courseId': 1}", unique = true)
public class Enrollment extends BaseAuditEntity {

    @Id
    private String id;

    @NotBlank(message = "Student ID is required")
    @Indexed
    private String studentId;

    @NotBlank(message = "Course ID is required")
    @Indexed
    private String courseId;

    @NotNull(message = "Enrollment date is required")
    @PastOrPresent(message = "Enrollment date cannot be in the future")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "d/M/yyyy")
    private LocalDate enrolledAt;

}
