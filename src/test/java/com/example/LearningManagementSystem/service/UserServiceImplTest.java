package com.example.LearningManagementSystem.service;

import com.example.LearningManagementSystem.Enum.Role;
import com.example.LearningManagementSystem.authenticationAndAuthorization.AuthenticationRequest;
import com.example.LearningManagementSystem.authenticationAndAuthorization.AuthenticationResponse;
import com.example.LearningManagementSystem.dto.UserRequestDto;
import com.example.LearningManagementSystem.dto.UserResponseDto;
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
class UserServiceImplTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserServices userServices;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @BeforeEach
    void setUp() {
        userRepository.deleteAll();
    }

    @Test
    void createUser() {
        UserRequestDto request = UserRequestDto.builder()
                .name("Musa")
                .email("musa@gmail.com")
                .password("1234")
                .role(Role.STUDENT)
                .build();

        assertEquals(0, userRepository.count());
        UserResponseDto createdUser = userServices.createUser(request);
        assertEquals(1, userRepository.count());
        assertNotNull(createdUser);
        assertEquals("musa@gmail.com", createdUser.getEmail());

        User savedUser = userRepository.findByEmail("musa@gmail.com").orElseThrow();
        assertEquals("musa@gmail.com", savedUser.getEmail());
        assertTrue(passwordEncoder.matches("1234", savedUser.getPassword())
        );
    }

        @Test
        void updateUser() {
            User user = User.builder()
                    .name("Musa Abdul Daud")
                    .email("musa@gmail.com")
                    .password(passwordEncoder.encode("1111"))
                    .role(Role.STUDENT)
                    .build();
            User savedUser = userRepository.save(user);
            String userId = savedUser.getId();

            UserRequestDto updateRequest = UserRequestDto.builder()
                    .name("Musa  Daud")
                    .password("12345")
                    .build();

            UserResponseDto response = userServices.updateUser(userId, updateRequest);
            assertNotNull(response);

            User updatedDbUser = userRepository.findById(userId).orElseThrow();
            assertEquals("Musa  Daud", updatedDbUser.getName());
            assertTrue(passwordEncoder.matches("12345", updatedDbUser.getPassword()));

            assertEquals("musa@gmail.com", updatedDbUser.getEmail());
        }


    @Test
    void removeUser() {
            String password = "1111";
            User user = new User();
            user.setId("23L");
            user.setEmail("HashimSalih2@gmail.com");
            user.setRole(Role.STUDENT);
            user.setPassword(password);
            user.setName("Lookman");
            userRepository.save(user);

            userServices.removeUser(user.getId());
            assertNotNull(user);
            assertEquals("23L", user.getId());
    }
}