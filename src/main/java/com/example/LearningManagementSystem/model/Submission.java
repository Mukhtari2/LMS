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
@Document(collection = "submissions")
public class Submission {

   @Id
    private String id;

    private Assignment assignment;

    private Long studentId;

    private String fileUrl;

    private String answeredAt;

    private Integer grade;

    private String feedback;

    private Date submittedAt;

}
