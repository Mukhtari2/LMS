package com.example.LearningManagementSystem.service;


import com.example.LearningManagementSystem.Enum.Role;
import com.example.LearningManagementSystem.authenticationAndAuthorization.AuthenticationRequest;
import com.example.LearningManagementSystem.authenticationAndAuthorization.AuthenticationResponse;
import com.example.LearningManagementSystem.model.User;
import com.example.LearningManagementSystem.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;


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

        assertEquals(0, userRepository.count());
        AuthenticationResponse newUser = authenticationService.register(user);
        assertEquals(1, userRepository.count());
        assertNotNull(newUser);
        assertEquals("Musa", user.getName());
        assertEquals("Musa@gmail.com", user.getEmail());
    }

    @Test
    void toAuthenticateUser() {
        String plainPassword = "password123";
        User userEntity = User.builder()
                .name("Musa")
                .email("musa@gmail.com")
                .password(passwordEncoder.encode(plainPassword))
                .role(Role.TEACHER)
                .build();
        userRepository.save(userEntity);

        AuthenticationRequest authRequest = new AuthenticationRequest();
        authRequest.setEmail("musa@gmail.com");
        authRequest.setPassword(plainPassword);

        AuthenticationResponse response = authenticationService.authenticate(authRequest);
        assertNotNull(response);
        assertNotNull(response.getToken());
        assertFalse(response.getToken().isEmpty());
    }

    @Test
    void toDeleteUser(){
        String password = "1111";
        User user = new User();
        user.setId("23L");
        user.setEmail("HashimSalih2@gmail.com");
        user.setRole(Role.STUDENT);
        user.setPassword(password);
        user.setName("Lookman");
        userRepository.save(user);

        authenticationService.removeUser(user.getId());

        assertNotNull(user);
        assertEquals("23L", user.getId());


    }
}