package com.example.LearningManagementSystem.repository;

import com.example.LearningManagementSystem.model.Assignment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AssignmentRepository extends MongoRepository<Assignment, String> {
    Optional<Assignment> findByCourseId(String courseId);
}
