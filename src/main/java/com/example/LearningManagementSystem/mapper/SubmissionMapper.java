package com.example.LearningManagementSystem.mapper;

import com.example.LearningManagementSystem.Enum.Grade;
import com.example.LearningManagementSystem.dto.SubmissionRequestDTO;
import com.example.LearningManagementSystem.dto.SubmissionResponseDTO;
import com.example.LearningManagementSystem.model.Assignment;
import com.example.LearningManagementSystem.model.Submission;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, imports = {LocalDate.class})
public interface SubmissionMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "assignment", source = "assignment.id")
    @Mapping(target = "studentId", source = "requestDTO.studentId")
    @Mapping(target = "answeredAt", source = "requestDTO.answeredAt")
    @Mapping(target = "fileUrl", source = "requestDTO.fileUrl")
    @Mapping(target = "submittedAt", expression = "java(LocalDate.now())")
    @Mapping(target = "grade", source = "requestDTO.grade")
    @Mapping(target = "feedback", source = "requestDTO.feedback")

    Submission toEntity(SubmissionRequestDTO requestDTO, Assignment assignment);

    SubmissionResponseDTO toDto(Submission submission);

    default Grade mapGrade(int gradeValue) {
        if (gradeValue >= 70) return Grade.EXCELLENT;
        if (gradeValue >= 60) return Grade.VERY_GOOD;
        if (gradeValue >= 50) return Grade.SATISFACTORY;
        if (gradeValue >= 45) return Grade.GOOD;
        if (gradeValue >= 40) return Grade.PASS;
        return Grade.FAIL;
    }
}
