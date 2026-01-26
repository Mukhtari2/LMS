package com.example.LearningManagementSystem.service;

import com.example.LearningManagementSystem.authenticationAndAuthorization.AuthenticationRequest;
import com.example.LearningManagementSystem.authenticationAndAuthorization.AuthenticationResponse;

public interface AuthenticationService {
    AuthenticationResponse register(AuthenticationRequest request);

    AuthenticationResponse authenticate (AuthenticationRequest request);
    void removeUser (String userId);
}
