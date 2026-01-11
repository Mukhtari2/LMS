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
@Document(collection = "enrollments")
public class Enrollment {

    @Id
    private String id;

    private Long studentId;

    private Course courseId;

    private Date enrolledAt;

}
