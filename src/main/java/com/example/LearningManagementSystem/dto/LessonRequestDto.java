package com.example.LearningManagementSystem.dto;

import lombok.*;

@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LessonRequestDto {

    private String lessonId;

    private String courseId;

    private String title;

    private String contentUrl;

}
