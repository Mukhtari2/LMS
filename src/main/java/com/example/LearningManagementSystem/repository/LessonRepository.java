package com.example.LearningManagementSystem.repository;

import com.example.LearningManagementSystem.model.Lesson;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LessonRepository extends MongoRepository<Lesson, Long> {
    Optional<Lesson> findById(Long lessonId);
}
