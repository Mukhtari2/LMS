package com.example.LearningManagementSystem.dto;

import com.example.LearningManagementSystem.Enum.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class UserRequestDto {

    private String name;

    private String email;

    private String password;

    private Role role;
}
