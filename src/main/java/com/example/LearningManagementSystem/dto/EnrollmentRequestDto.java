package com.example.LearningManagementSystem.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@ToString
@RequiredArgsConstructor
public class EnrollmentRequestDto {

    private String studentId;

    private String courseId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "d/M/yyyy")
    private LocalDate enrolledAt;

}

