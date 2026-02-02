package com.example.LearningManagementSystem.dto;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TokenVerificationResponseDto {

    private String message;

    private boolean success;

    private LocalDateTime timestamp;

}
