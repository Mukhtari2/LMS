package com.example.LearningManagementSystem.mapper;

import com.example.LearningManagementSystem.dto.LessonRequestDTO;
import com.example.LearningManagementSystem.dto.LessonResponseDTO;
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
    Lesson toEntity(LessonRequestDTO lessonRequestDTO, Course courseId);
    LessonResponseDTO toDto(Lesson lesson);
}
