package com.example.LearningManagementSystem.controller;

import com.example.LearningManagementSystem.dto.TokenVerificationRequestDto;
import com.example.LearningManagementSystem.service.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/verification")
@RequiredArgsConstructor
public class TokenVerificationController {

    @Autowired
    private UserServices userServices;

    @PostMapping("/verify")
    public ResponseEntity<String> verifyEmail(@RequestBody TokenVerificationRequestDto requestDto) {
        boolean isVerified = userServices.verifyCode(requestDto.getEmail(), requestDto.getCode()); // Example service call
        if (isVerified) {
            return ResponseEntity.ok("Email verified successfully!");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid or expired code.");
    }

}
