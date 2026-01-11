package com.example.LearningManagementSystem.dto;

import com.example.LearningManagementSystem.Enum.Status;
import lombok.*;

@Setter
@Getter
@ToString
@RequiredArgsConstructor
public class CourseRequestDTO {

    private Long id;

    private String title;

    private String description;

    private Status status;

    private Long teacherId;

}
