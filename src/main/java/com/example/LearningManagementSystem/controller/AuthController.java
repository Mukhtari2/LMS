package com.example.LearningManagementSystem.controller;

import com.example.LearningManagementSystem.authenticationAndAuthorization.AuthenticationRequest;
import com.example.LearningManagementSystem.authenticationAndAuthorization.AuthenticationResponse;
import com.example.LearningManagementSystem.service.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authenticationService;


    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register (@Valid @RequestBody AuthenticationRequest request){
        AuthenticationResponse registerRequest = authenticationService.register(request);
        return new ResponseEntity<>(registerRequest, HttpStatus.CREATED);
        
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
        return ResponseEntity.ok( authenticationService.authenticate(request));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/remove-User/{userId}")
    public ResponseEntity<?> removeUser(@PathVariable String userId){
        authenticationService.removeUser(userId);
        return ResponseEntity.ok("User deleted successfully");
    }

}
