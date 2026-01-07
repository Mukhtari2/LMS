package com.example.LearningManagementSystem.service;

import com.example.LearningManagementSystem.dto.SubmissionRequestDTO;
import com.example.LearningManagementSystem.dto.SubmissionResponseDTO;
import com.example.LearningManagementSystem.mapper.SubmissionMapper;
import com.example.LearningManagementSystem.model.Assignment;
import com.example.LearningManagementSystem.model.Submission;
import com.example.LearningManagementSystem.repository.SubmissionRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubmissionServiceImpl implements SubmissionService{

    private final AssignmentService assignmentService;
    private final SubmissionRepository submissionRepository;
    private SubmissionMapper submissionMapper;

    @Override
    public SubmissionResponseDTO submitAnswers(SubmissionRequestDTO requestDTO) {
        Assignment assignment = assignmentService.findByAssignmentId(requestDTO.getAssignmentId());
        if (assignment != null){
            Submission submission = submissionMapper.toEntity(requestDTO, assignment);
            Submission newSubmission = submissionRepository.save(submission);
            return submissionMapper.toDto(newSubmission);
        }else throw new EntityNotFoundException("No assignment Id found for this submission");
    }


}
