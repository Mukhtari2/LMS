package com.example.LearningManagementSystem.controller;

import com.example.LearningManagementSystem.authenticationAndAuthorization.AuthenticationRequest;
import com.example.LearningManagementSystem.authenticationAndAuthorization.AuthenticationResponse;
import com.example.LearningManagementSystem.dto.UserRequestDto;
import com.example.LearningManagementSystem.dto.UserResponseDto;
import com.example.LearningManagementSystem.service.AuthenticationService;
import com.example.LearningManagementSystem.service.UserServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authenticationService;
    private final UserServices userServices;


    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register (@Valid @RequestBody AuthenticationRequest request){
        AuthenticationResponse registerRequest = authenticationService.register(request);
        return new ResponseEntity<>(registerRequest, HttpStatus.CREATED);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest request){
        return ResponseEntity.ok( authenticationService.login(request));
    }


    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create-user")
    public ResponseEntity<UserResponseDto> createNewUser (@Valid @RequestBody UserRequestDto request){
        UserResponseDto createUser = userServices.createUser(request);
        return new ResponseEntity<>(createUser, HttpStatus.CREATED);
    }


    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/remove-User/{userId}")
    public ResponseEntity<?> removeUser(@PathVariable String userId){
        userServices.removeUser(userId);
        return ResponseEntity.ok("User deleted successfully");
    }

}
