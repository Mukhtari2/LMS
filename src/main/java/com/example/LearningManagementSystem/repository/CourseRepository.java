package com.example.LearningManagementSystem.repository;

import com.example.LearningManagementSystem.model.Course;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepository extends MongoRepository<Course, Long> {
    Optional<Course> findById(Long courseId);
}
