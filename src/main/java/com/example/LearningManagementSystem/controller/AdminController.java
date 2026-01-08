package com.example.LearningManagementSystem.controller;

import com.example.LearningManagementSystem.dto.UserRequestDTO;
import com.example.LearningManagementSystem.dto.UserResponseDTO;
import com.example.LearningManagementSystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin")
@PreAuthorize("hasRole('ADMIN')")
@RequiredArgsConstructor
public class AdminController {

    private UserService userService;

    @PostMapping("/register-user")
    public ResponseEntity<UserResponseDTO> registerUser (@RequestBody UserRequestDTO userRequestDTO){
        UserResponseDTO userResponseDTO = userService.register(userRequestDTO);
        return new ResponseEntity<>(userResponseDTO, HttpStatus.CREATED);

    }

}
