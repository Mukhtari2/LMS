package com.example.LearningManagementSystem.dto;

import com.example.LearningManagementSystem.Enum.Role;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor  // <--- ADD THIS
@AllArgsConstructor
public class UserRequestDto {

    private String name;

    private String email;

    private String password;

    private Role role;
}
