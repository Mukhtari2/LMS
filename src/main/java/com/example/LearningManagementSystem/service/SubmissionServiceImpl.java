package com.example.LearningManagementSystem.service;

import com.example.LearningManagementSystem.Exception.ResourceNotFoundException;
import com.example.LearningManagementSystem.dto.SubmissionRequestDTO;
import com.example.LearningManagementSystem.dto.SubmissionResponseDTO;
import com.example.LearningManagementSystem.mapper.SubmissionMapper;
import com.example.LearningManagementSystem.model.Assignment;
import com.example.LearningManagementSystem.model.Submission;
import com.example.LearningManagementSystem.repository.SubmissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SubmissionServiceImpl implements SubmissionService{

    private final AssignmentService assignmentService;
    private final SubmissionRepository submissionRepository;
    private final SubmissionMapper submissionMapper;


    @Override
    public SubmissionResponseDTO submitAnswers(SubmissionRequestDTO requestDTO) {
//        Assignment assignment = assignmentService.findByAssignmentId(requestDTO.getAssignmentId());
//        if (assignment == null) {
//            throw new ResourceNotFoundException("No assignment Id found for this submission");
//        }
//            Submission submission = submissionMapper.toEntity(requestDTO, assignment);
//            Submission newSubmission = submissionRepository.insert(submission);
//            return submissionMapper.toDto(newSubmission);

        return Optional.ofNullable(assignmentService.findByAssignmentId(requestDTO.getAssignmentId()))
                .map(assignment -> submissionMapper.toEntity(requestDTO, assignment))
                .map(submissionRepository::insert)
                .map(submissionMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("No assignment Id found for this submission"));
    }


    @Override
    public SubmissionResponseDTO viewSubmission(String submissionId) {
        Submission id = submissionRepository.findById(submissionId).orElseThrow
                (() -> new ResourceNotFoundException
                        ("Assignment with ID " + submissionId + " not found "));

        return submissionMapper.toDto(id);
    }



    @Override
    public List<SubmissionResponseDTO> viewAllSubmission() {
            return submissionRepository.findAll()
                    .stream()
                    .map(submissionMapper::toDto)
                    .toList();
        }


}
