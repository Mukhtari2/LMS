package com.example.LearningManagementSystem.dto;

import lombok.*;

@Setter
@Getter
@ToString
@RequiredArgsConstructor
public class LessonResponseDto {

    private String id;

    private String courseId;

    private String title;

    private String contentUrl;

}
