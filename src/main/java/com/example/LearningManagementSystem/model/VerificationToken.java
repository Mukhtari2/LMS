package com.example.LearningManagementSystem.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Setter
@Getter
@Builder
@Document(collection = "verification_tokens")
public class VerificationToken extends BaseAuditEntity{
    @Id
    private String id;
    private String token;
    private String email;

    @Indexed(expireAfter = "600s")
    private LocalDateTime createdAt;
}

