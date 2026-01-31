package com.example.LearningManagementSystem.controller;

import com.example.LearningManagementSystem.dto.*;
import com.example.LearningManagementSystem.service.AssignmentService;
import com.example.LearningManagementSystem.service.EnrollmentService;
import com.example.LearningManagementSystem.service.SubmissionService;
import com.example.LearningManagementSystem.service.UserServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
@PreAuthorize("hasRole('STUDENT')")
public class StudentController {

    private final UserServices userServices;
    private final EnrollmentService enrollmentService;
    private final SubmissionService submissionService;
    private final AssignmentService assignmentService;


    @PreAuthorize("#userId == authentication.principal.id")
    @PostMapping("/update-user/{userId}")
    public ResponseEntity<UserResponseDto> updateUser (@Valid @PathVariable String userId, @RequestBody UserRequestDto userRequest){
        UserResponseDto updatedUser = userServices.updateUser(userId, userRequest);
        return ResponseEntity.ok(updatedUser);
    }

    @PostMapping("/enroll")
    public ResponseEntity<EnrollmentResponseDto> enrolPublishedCourse(@RequestBody EnrollmentRequestDto enrollmentRequestDTO) {
        EnrollmentResponseDto enroll = enrollmentService.enrollPublishedCourse(enrollmentRequestDTO);
        return new ResponseEntity<>(enroll, HttpStatus.CREATED);
    }

    @GetMapping("/all-enrolled-courses")
    public ResponseEntity<List<EnrollmentResponseDto> >viewAllEnrolledCourses(){
        List<EnrollmentResponseDto> viewAllEnrollment = enrollmentService.viewAllEnrolledCourses();
        return ResponseEntity.ok(viewAllEnrollment);
    }

    @PostMapping("/submit-answer")
    public ResponseEntity<SubmissionResponseDto>  submitAnswers(@RequestBody SubmissionRequestDto submissionRequestDTO){
        SubmissionResponseDto responseDTO = submissionService.submitAnswers(submissionRequestDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/view-submission/{assignmentId}")
    public ResponseEntity<SubmissionResponseDto> viewSubmission(@PathVariable String assignmentId){
        SubmissionResponseDto submissionResponse = submissionService.viewSubmission(assignmentId);
        return ResponseEntity.ok(submissionResponse);
    }

    @GetMapping("/all-submissions")
    public ResponseEntity<List<SubmissionResponseDto> >viewAllSubmission(){
        List<SubmissionResponseDto> viewAllSubmissionsRequest = submissionService.viewAllSubmissions();
        return ResponseEntity.ok(viewAllSubmissionsRequest);
    }

    @GetMapping("/view-assignment/{assignmentId}")
    public ResponseEntity<AssignmentResponseDto> viewAssignment (@PathVariable String assignmentId) {
        AssignmentResponseDto responseDTO = assignmentService.viewAssignment(assignmentId);
        return ResponseEntity.ok(responseDTO);
    }

}

