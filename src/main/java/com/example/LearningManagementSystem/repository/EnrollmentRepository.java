package com.example.LearningManagementSystem.repository;

import com.example.LearningManagementSystem.model.Enrollment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollmentRepository extends MongoRepository<Enrollment, Long> {

}
