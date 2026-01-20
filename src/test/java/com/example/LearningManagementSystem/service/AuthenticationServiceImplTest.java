package com.example.LearningManagementSystem.service;

import com.example.LearningManagementSystem.Enum.Role;
import com.example.LearningManagementSystem.authenticationAndAuthorization.AuthenticationRequest;
import com.example.LearningManagementSystem.authenticationAndAuthorization.AuthenticationResponse;
import com.example.LearningManagementSystem.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
@ActiveProfiles("test")
class AuthenticationServiceImplTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationService authenticationService;

    @BeforeEach
    void setUp() {
        userRepository.deleteAll();
    }

    @Test
    void toRegisterNewUser() {
        AuthenticationRequest user = new AuthenticationRequest();
        user.setName("Musa");
        user.setEmail("Musa@gmail.com");
        user.setPassword(passwordEncoder.encode("1234"));
        AuthenticationResponse newUser = authenticationService.register(user);

        assertNotNull(newUser);


    }
}