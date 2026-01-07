package com.example.LearningManagementSystem.service;

import com.example.LearningManagementSystem.dto.AssignmentRequestDTO;
import com.example.LearningManagementSystem.dto.AssignmentResponseDTO;
import com.example.LearningManagementSystem.mapper.AssignmentMapper;
import com.example.LearningManagementSystem.model.Assignment;
import com.example.LearningManagementSystem.model.Course;
import com.example.LearningManagementSystem.repository.AssignmentRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AssignmentServiceImpl implements AssignmentService {

    private final CourseService courseService;
    private final AssignmentRepository assignmentRepository;
    private AssignmentMapper assignmentMapper;

    @Override
    public AssignmentResponseDTO viewAssignment(AssignmentRequestDTO requestDTO) {
        return assignmentRepository.findById(requestDTO.getId())
                .map(assignmentMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException
                        ("Assignment not found with ID: " + requestDTO.getId()));
    }

    @Override
    public AssignmentResponseDTO submitAssignment(AssignmentRequestDTO requestDTO) {
        Course course = courseService.findByCourseId(requestDTO.getCourseId());
        if (course != null) {
            Assignment viewAssignment = assignmentMapper.toEntity(requestDTO, course);
            Assignment saveAssignment = assignmentRepository.save(viewAssignment);
            return assignmentMapper.toDto(saveAssignment);
        } else throw new EntityNotFoundException
                ("No course id found to view assignment");
    }

    @Override
    public Assignment findByAssignmentId(Long assignmentId) {
        return assignmentRepository.findById(assignmentId).orElseThrow();
    }

}
