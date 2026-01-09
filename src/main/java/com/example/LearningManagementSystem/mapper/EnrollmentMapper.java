package com.example.LearningManagementSystem.mapper;

import com.example.LearningManagementSystem.dto.EnrollmentRequestDTO;
import com.example.LearningManagementSystem.dto.EnrollmentResponseDTO;
import com.example.LearningManagementSystem.model.Course;
import com.example.LearningManagementSystem.model.Enrollment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, imports = {java.util.Date.class})
public interface EnrollmentMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "courseId", source = "course")
    @Mapping(target = "studentId", source = "request.studentId")
    @Mapping(target = "enrolledAt", expression = "java(new Date(System.currentTimeMillis()))")

    Enrollment toEntity(EnrollmentRequestDTO request, Course course);
    EnrollmentResponseDTO toDto(Enrollment enrollment);
}

