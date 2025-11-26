package com.example.collegemanager.map;

import com.example.collegemanager.entity.Course;
import com.example.collegemanager.dto.course.CourseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;


@Component
public class CourseMapping {

    public CourseDTO toDTO(Course course){
        return CourseDTO.builder()
                .id(course.getId())
                .name(course.getName())
                .teacher(course.getTeacher())
                .build();
    }
}
