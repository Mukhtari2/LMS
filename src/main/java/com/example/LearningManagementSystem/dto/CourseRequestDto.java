package com.example.LearningManagementSystem.dto;

import com.example.LearningManagementSystem.Enum.Role;
import com.example.LearningManagementSystem.Enum.Status;
import lombok.*;

@Setter
@Getter
@ToString
@RequiredArgsConstructor
public class CourseRequestDto {

    private String id;

    private String title;

    private String description;

    private Status status;

    private String teacherId;

    private Role role;

}
