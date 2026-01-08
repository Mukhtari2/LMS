package com.example.LearningManagementSystem.controller;

import com.example.LearningManagementSystem.dto.CourseRequestDTO;
import com.example.LearningManagementSystem.dto.CourseResponseDTO;
import com.example.LearningManagementSystem.model.Course;
import com.example.LearningManagementSystem.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("api/v1/courses")
public class CourseController {


    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/register")
    public ResponseEntity<CourseResponseDTO> registerCourse (@RequestBody CourseRequestDTO courseRequestDTO){
        CourseResponseDTO courseResponseDTO = courseService.registerCourse(courseRequestDTO);
        return new ResponseEntity<>(courseResponseDTO, HttpStatus.CREATED);
    }
}
