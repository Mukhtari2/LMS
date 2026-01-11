package com.example.LearningManagementSystem.dto;

import com.example.LearningManagementSystem.model.Course;
import lombok.*;

@Setter
@Getter
@ToString
@RequiredArgsConstructor
public class LessonResponseDTO {

    private Long id;

    private Long courseId;

    private String title;

    private String contentUrl;

}
