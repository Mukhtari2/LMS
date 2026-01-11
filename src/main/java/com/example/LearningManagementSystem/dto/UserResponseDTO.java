package com.example.LearningManagementSystem.dto;

import lombok.*;

@Setter
@Getter
@ToString
@RequiredArgsConstructor
public class UserResponseDTO {

    private String id;

    private String name;

    private String email;

}
