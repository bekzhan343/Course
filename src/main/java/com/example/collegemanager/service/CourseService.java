package com.example.collegemanager.service;

import com.example.collegemanager.dto.course.CourseDTO;
import com.example.collegemanager.response.CourseResponse;
import lombok.NonNull;
import org.jetbrains.annotations.NotNull;

public interface CourseService {

    CourseResponse<CourseDTO> getCourseByID(@NotNull Integer id);

    CourseResponse<CourseDTO> createCourse(@NotNull CourseDTO courseDTO);
}
