package com.example.LearningManagementSystem.service;

public interface VerificationService {
    String generateVerificationCode();
    void sendVerificationEmail(String email, String code);
}
