package com.example.collegemanager.map;

import com.example.collegemanager.dto.course.CourseDTO;
import com.example.collegemanager.entity.Course;
import org.springframework.stereotype.Component;

@Component
public class EntityMapping {

    public Course toEntity(CourseDTO dto){
        Course course = new Course();
        course.setId(dto.getId());
        course.setName(dto.getName());
        course.setTeacher(dto.getTeacher());

        return course;
    }

}
