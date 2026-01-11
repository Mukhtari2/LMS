package com.example.LearningManagementSystem.dto;

import com.example.LearningManagementSystem.model.Course;
import lombok.*;

@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LessonRequestDTO {

    private Long courseId;

    private String title;

    private String contentUrl;

}
