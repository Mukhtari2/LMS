package com.example.LearningManagementSystem.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class UserResponseDto {

    private String email;

    private String password;
}
