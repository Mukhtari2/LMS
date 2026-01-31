package com.example.LearningManagementSystem.controller;

import com.example.LearningManagementSystem.dto.*;
import com.example.LearningManagementSystem.service.AssignmentService;
import com.example.LearningManagementSystem.service.CourseService;
import com.example.LearningManagementSystem.service.LessonService;
import com.example.LearningManagementSystem.service.UserServices;
import jakarta.validation.Valid;
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

    private final UserServices userServices;
    private final CourseService courseService;
    private final LessonService lessonService;
    private final AssignmentService assignmentService;


    @PreAuthorize("#userId == authentication.principal.id")
    @PostMapping("/update-user/{userId}")
    public ResponseEntity<UserResponseDto> updateUser (@Valid @PathVariable String userId, @RequestBody UserRequestDto userRequest){
        UserResponseDto updatedUser = userServices.updateUser(userId, userRequest);
        return ResponseEntity.ok(updatedUser);
    }

    @PostMapping("/register-course")
    public ResponseEntity<CourseResponseDto> registerCourse (@RequestBody CourseRequestDto courseRequestDTO){
        CourseResponseDto courseResponseDTO = courseService.registerCourse(courseRequestDTO);
        return new ResponseEntity<>(courseResponseDTO, HttpStatus.CREATED);
    }

    @PutMapping("/update-course/{courseId}")
    public ResponseEntity<CourseResponseDto> updateCourse (@PathVariable String courseId, @RequestBody CourseRequestDto requestDTO){
        CourseResponseDto responseDTO = courseService.updateCourse(courseId, requestDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/all-courses")
    public ResponseEntity<List<CourseResponseDto>> viewAllCourses () {
        List<CourseResponseDto> responseDTO = courseService.viewAllCreatedCourses();
        return ResponseEntity.ok(responseDTO);
    }

    @PostMapping("/addLesson")
    public ResponseEntity<LessonResponseDto> addLesson (@RequestBody LessonRequestDto lessonRequestDTO){
        LessonResponseDto newLesson = lessonService.addLesson(lessonRequestDTO);
        return new ResponseEntity<>(newLesson, HttpStatus.CREATED);
    }

    @GetMapping("/all-lessons")
    public ResponseEntity<List<LessonResponseDto>> viewAllLessons () {
        List<LessonResponseDto> responseDTO = lessonService.viewAllLessons();
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("view-lesson/{courseId}")
    public ResponseEntity<LessonResponseDto> viewLessonByCourseId(@PathVariable String courseId){
        LessonResponseDto viewLessonRequest = lessonService.viewLesson(courseId);
        return ResponseEntity.ok(viewLessonRequest);
    }

    @PostMapping("/create-Assignment")
    public ResponseEntity<AssignmentResponseDto> createAssignment (@RequestBody AssignmentRequestDto assignmentRequestDTO) {
        AssignmentResponseDto responseDTO = assignmentService.createAssignment(assignmentRequestDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }
}
