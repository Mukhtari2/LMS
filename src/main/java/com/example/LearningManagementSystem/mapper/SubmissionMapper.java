package com.example.LearningManagementSystem.mapper;

import com.example.LearningManagementSystem.dto.SubmissionRequestDTO;
import com.example.LearningManagementSystem.dto.SubmissionResponseDTO;
import com.example.LearningManagementSystem.model.Assignment;
import com.example.LearningManagementSystem.model.Submission;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", imports = {java.util.Date.class})
public interface SubmissionMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "assignment_Id", source = "request.assignment")
    @Mapping(target = "student_Id", source = "request.studentId")
    @Mapping(target = "answerText", source = "request.answerText")
    @Mapping(target = "submittedAt", expression = "java.newDate(System.currentTimeMillis())")
    @Mapping(target = "grade", source = "request.grade")
    @Mapping(target = "feedback", source = "request.feedback")
    Submission toEntity(SubmissionRequestDTO requestDTO, Assignment assignment);
    SubmissionResponseDTO toDto(Submission submission);
}
