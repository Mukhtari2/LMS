package com.example.LearningManagementSystem.authenticationAndAuthorization;

import com.example.LearningManagementSystem.Enum.Role;
import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequest {
    private String name;
    private String email;
    private String password;
    private String role;
}
