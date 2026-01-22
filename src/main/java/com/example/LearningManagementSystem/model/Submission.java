package com.example.LearningManagementSystem.model;

import com.example.LearningManagementSystem.Enum.Grade;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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

    private Assignment assignment;

    private String studentId;

    private String fileUrl;

    private LocalDateTime answeredAt;

    private Grade grade;

    private String feedback;

    private LocalDateTime submittedAt;

}
