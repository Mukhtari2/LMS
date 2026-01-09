package com.example.LearningManagementSystem.controller;

import com.example.LearningManagementSystem.dto.*;
//import com.example.LearningManagementSystem.service.AssignmentService;
import com.example.LearningManagementSystem.service.EnrollmentService;
//import com.example.LearningManagementSystem.service.SubmissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/student")
@PreAuthorize("hasRole('STUDENT')")
@RequiredArgsConstructor
public class StudentController {

    private final EnrollmentService enrollmentService;
//    private final SubmissionService submissionService;
//    private final AssignmentService assignmentService;

    @PostMapping("/enroll")
    public ResponseEntity<EnrollmentResponseDTO> enrolPublishedCourse(@RequestBody EnrollmentRequestDTO enrollmentRequestDTO) {
        EnrollmentResponseDTO enroll = enrollmentService.enrollPublishedCourse(enrollmentRequestDTO);
        return new ResponseEntity<>(enroll, HttpStatus.CREATED);
    }

//    @PostMapping("/submit-answer")
//    public ResponseEntity<SubmissionResponseDTO>  submitAnswer(@RequestBody SubmissionRequestDTO submissionRequestDTO){
//        SubmissionResponseDTO responseDTO = submissionService.submitAnswers(submissionRequestDTO);
//        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
//    }
//
//    @GetMapping("/view/{assignmentId}")
//    public ResponseEntity<AssignmentResponseDTO> viewAssignment (@PathVariable Long assignmentId) {
//        AssignmentResponseDTO responseDTO = assignmentService.viewAssignment(assignmentId);
//        return ResponseEntity.ok(responseDTO);
//    }



}
