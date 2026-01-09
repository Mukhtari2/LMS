package com.example.LearningManagementSystem.controller;

import com.example.LearningManagementSystem.dto.*;
//import com.example.LearningManagementSystem.service.AssignmentService;
import com.example.LearningManagementSystem.service.CourseService;
//import com.example.LearningManagementSystem.service.LessonService;
import com.example.LearningManagementSystem.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/teacher")
@PreAuthorize("hasRole('TEACHER')")
@RequiredArgsConstructor
public class TeacherController {

    private final CourseService courseService;
    private final LessonService lessonService;
//    private final AssignmentService assignmentService;

    @PostMapping("/registerCourse")
    public ResponseEntity<CourseResponseDTO> registerCourse (@RequestBody CourseRequestDTO courseRequestDTO){
        CourseResponseDTO courseResponseDTO = courseService.registerCourse(courseRequestDTO);
        return new ResponseEntity<>(courseResponseDTO, HttpStatus.CREATED);
    }

    @PostMapping("/addLesson")
    public ResponseEntity<LessonResponseDTO> addLesson (LessonRequestDTO lessonRequestDTO){
        LessonResponseDTO newLesson = lessonService.addLesson(lessonRequestDTO);
        return new ResponseEntity<>(newLesson, HttpStatus.CREATED);
    }
//
//    @PostMapping("/create-Assignment")
//    public ResponseEntity<AssignmentResponseDTO> createAssignment (@RequestBody AssignmentRequestDTO assignmentRequestDTO) {
//        AssignmentResponseDTO responseDTO = assignmentService.createAssignment(assignmentRequestDTO);
//        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
//    }
}
