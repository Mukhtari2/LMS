package com.example.LearningManagementSystem.service;

import com.example.LearningManagementSystem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
@RequiredArgsConstructor
public class VerificationServiceImpl {


    private final JavaMailSender mailSender;
    private final UserRepository userRepository; // Example repository

    public String generateVerificationCode() {
        SecureRandom random = new SecureRandom();
        int code = 1000 + random.nextInt(9000); // Generates 1000-9999
        return String.valueOf(code);
    }

    public void sendVerificationEmail(String email, String code) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Verify your email");
        message.setText("Your verification code is: " + code);
        mailSender.send(message);
    }
}

