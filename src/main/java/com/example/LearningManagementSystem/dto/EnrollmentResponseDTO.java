package com.example.LearningManagementSystem.dto;

//import com.example.LearningManagementSystem.model.Course;
import com.example.LearningManagementSystem.model.Course;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@RequiredArgsConstructor
public class EnrollmentResponseDTO {
    private Long id;
    private Long studentId;
    private Course courseId;
    private Date enrolledAt;
}
