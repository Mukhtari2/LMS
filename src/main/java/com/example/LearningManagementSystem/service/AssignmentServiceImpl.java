package com.example.LearningManagementSystem.service;

import com.example.LearningManagementSystem.Exception.ResourceNotFoundException;
import com.example.LearningManagementSystem.dto.AssignmentRequestDTO;
import com.example.LearningManagementSystem.dto.AssignmentResponseDTO;
import com.example.LearningManagementSystem.mapper.AssignmentMapper;
import com.example.LearningManagementSystem.model.Assignment;
import com.example.LearningManagementSystem.repository.AssignmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AssignmentServiceImpl implements AssignmentService {

    private final CourseService courseService;
    private final AssignmentRepository assignmentRepository;
    private final AssignmentMapper assignmentMapper;


    @Override
    public AssignmentResponseDTO viewAssignment(String courseId) {
        Assignment assignment = assignmentRepository.findById(courseId)
                .orElseThrow(() -> new ResourceNotFoundException
                        ("Assignment with ID " + courseId + " not found "));

        return assignmentMapper.toDto(assignment);
    }

    @Override
    public AssignmentResponseDTO createAssignment(AssignmentRequestDTO requestDTO) {
        return Optional.ofNullable(courseService.findByCourseId(requestDTO.getCourse()))
                .map(course -> assignmentMapper.toEntity(requestDTO, course))
                .map(assignmentRepository::insert)
                .map(assignmentMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("No course id found to view assignment"));
    }


    @Override
    public Assignment findByAssignmentId(String assignmentId) {
        return assignmentRepository.findById(assignmentId).orElseThrow();
    }

}
