package com.example.LearningManagementSystem.service;

import com.example.LearningManagementSystem.Exception.ResourceNotFoundException;
import com.example.LearningManagementSystem.dto.SubmissionRequestDto;
import com.example.LearningManagementSystem.dto.SubmissionResponseDto;
import com.example.LearningManagementSystem.mapper.SubmissionMapper;
import com.example.LearningManagementSystem.model.Submission;
import com.example.LearningManagementSystem.repository.SubmissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SubmissionServiceImpl implements SubmissionService{

    private final AssignmentService assignmentService;
    private final SubmissionRepository submissionRepository;
    private final SubmissionMapper submissionMapper;

    @Override
    public SubmissionResponseDto submitAnswers(SubmissionRequestDto requestDTO) {
        return Optional.ofNullable(assignmentService.findByAssignmentId(requestDTO.getAssignmentId()))
                .map(assignmentId -> submissionMapper.toEntity(requestDTO, assignmentId))
                .map(submissionRepository::insert)
                .map(submissionMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("No assignment Id found for this submission"));
    }

    @Override
    public SubmissionResponseDto viewSubmission(String submissionId) {
        Submission id = submissionRepository.findById(submissionId).orElseThrow
                (() -> new ResourceNotFoundException
                        ("Assignment with ID " + submissionId + " not found "));
        return submissionMapper.toDto(id);
    }

    @Override
    public List<SubmissionResponseDto> viewAllSubmissions() {
            return submissionRepository.findAll()
                    .stream()
                    .map(submissionMapper::toDto)
                    .toList();
        }


}
