package com.example.LearningManagementSystem.authenticationAndAuthorization;

import com.example.LearningManagementSystem.Enum.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequest {
    private String name;
    private String email;
    private String password;
    private String role;
}
