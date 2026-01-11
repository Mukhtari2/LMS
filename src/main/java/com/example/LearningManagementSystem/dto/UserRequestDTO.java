package com.example.LearningManagementSystem.dto;

import lombok.*;

@Setter
@Getter
@ToString
@RequiredArgsConstructor
public class UserRequestDTO {

    private String id;

    private String name;

    private String email;

    private String password;

}
