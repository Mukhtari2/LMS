package com.example.LearningManagementSystem.mapper;

import com.example.LearningManagementSystem.dto.LessonRequestDto;
import com.example.LearningManagementSystem.dto.LessonResponseDto;
import com.example.LearningManagementSystem.model.Course;
import com.example.LearningManagementSystem.model.Lesson;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)

public interface LessonMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "course", source = "courseId")
    @Mapping(target = "title", source = "lessonRequestDTO.title")
    @Mapping(target = "contentUrl", source = "lessonRequestDTO.contentUrl")
    Lesson toEntity(LessonRequestDto lessonRequestDTO, Course courseId);
    @Mapping(target = "courseId", source = "lesson.course.id")
    LessonResponseDto toDto(Lesson lesson);
}
