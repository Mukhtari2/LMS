package com.example.LearningManagementSystem.repository;

import com.example.LearningManagementSystem.model.VerificationToken;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface VerificationTokenRepository extends MongoRepository<VerificationToken, String> {

    Optional<VerificationToken> findByEmailAndToken(String email, String code);

}
