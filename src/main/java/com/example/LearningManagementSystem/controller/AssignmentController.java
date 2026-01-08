package com.example.LearningManagementSystem.controller;

import com.example.LearningManagementSystem.dto.AssignmentRequestDTO;
import com.example.LearningManagementSystem.dto.AssignmentResponseDTO;
import com.example.LearningManagementSystem.model.Assignment;
import com.example.LearningManagementSystem.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/assignments")
public class  AssignmentController {


    private final AssignmentService assignmentService;

    public AssignmentController(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    @GetMapping
    public ResponseEntity<AssignmentResponseDTO> viewAssignment (@PathVariable AssignmentRequestDTO assignmentRequestDTO) {
        AssignmentResponseDTO responseDTO = assignmentService.viewAssignment(assignmentRequestDTO);
        return ResponseEntity.ok(responseDTO);

    }

    @PostMapping("/submit")
    public ResponseEntity<AssignmentResponseDTO> submitAssignment (@RequestBody AssignmentRequestDTO assignmentRequestDTO) {
        AssignmentResponseDTO responseDTO = assignmentService.submitAssignment(assignmentRequestDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }


}
