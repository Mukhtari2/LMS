package com.example.LearningManagementSystem.service;

public interface VerificationService {
    public String generateVerificationCode();
    public void sendVerificationEmail(String email, String code);
}
