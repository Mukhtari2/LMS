package com.example.LearningManagementSystem.dto;

//import com.example.LearningManagementSystem.model.Course;
import com.example.LearningManagementSystem.model.Course;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Setter
@Getter
@ToString
@RequiredArgsConstructor
public class EnrollmentResponseDTO {

    private String id;

    private String studentId;

    private Course courseId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "d/M/yyyy")
    private LocalDate enrolledAt;

}
