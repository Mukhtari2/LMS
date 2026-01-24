package com.example.LearningManagementSystem.controller;

import com.example.LearningManagementSystem.dto.*;
import com.example.LearningManagementSystem.service.AssignmentService;
import com.example.LearningManagementSystem.service.CourseService;
import com.example.LearningManagementSystem.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/teacher")
@PreAuthorize("hasRole('TEACHER')")
@RequiredArgsConstructor
public class TeacherController {

    private final CourseService courseService;
    private final LessonService lessonService;
    private final AssignmentService assignmentService;

    @PostMapping("/register-course")
    public ResponseEntity<CourseResponseDTO> registerCourse (@RequestBody CourseRequestDTO courseRequestDTO){
        CourseResponseDTO courseResponseDTO = courseService.registerCourse(courseRequestDTO);
        return new ResponseEntity<>(courseResponseDTO, HttpStatus.CREATED);
    }

    @PutMapping("/update-course/{courseId}")
    public ResponseEntity<CourseResponseDTO> updateCourse (@PathVariable String courseId, @RequestBody CourseRequestDTO requestDTO){
        CourseResponseDTO responseDTO = courseService.updateCourse(courseId, requestDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @PostMapping("/addLesson")
    public ResponseEntity<LessonResponseDTO> addLesson (LessonRequestDTO lessonRequestDTO){
        LessonResponseDTO newLesson = lessonService.addLesson(lessonRequestDTO);
        return new ResponseEntity<>(newLesson, HttpStatus.CREATED);
    }

    @PostMapping("/create-Assignment")
    public ResponseEntity<AssignmentResponseDTO> createAssignment (@RequestBody AssignmentRequestDTO assignmentRequestDTO) {
        AssignmentResponseDTO responseDTO = assignmentService.createAssignment(assignmentRequestDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/all-courses")
    public ResponseEntity<List<CourseResponseDTO>> viewAllCourses () {
        List<CourseResponseDTO> responseDTO = courseService.viewAllCreatedCourses();
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/all-lessons")
    public ResponseEntity<List<LessonResponseDTO>> viewAllLessons () {
        List<LessonResponseDTO> responseDTO = lessonService.viewAllLessons();
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("view-lesson/{courseId}")
    public ResponseEntity<LessonResponseDTO> viewLessonByCourseId(@PathVariable String courseId){
        LessonResponseDTO viewLessonRequest = lessonService.viewLesson(courseId);
        return ResponseEntity.ok(viewLessonRequest);
    }
}
