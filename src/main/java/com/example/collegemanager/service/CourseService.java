package com.example.collegemanager.service;

import com.example.collegemanager.dto.course.CourseDTO;
import com.example.collegemanager.response.IamResponse;
import org.jetbrains.annotations.NotNull;

public interface CourseService {

    IamResponse<CourseDTO> getCourseByID(@NotNull Integer id);

    IamResponse<CourseDTO> createCourse(@NotNull CourseDTO courseDTO);

    IamResponse<CourseDTO> updateCourse(@NotNull Integer id, @NotNull CourseDTO courseDTO);

    void softDelete(@NotNull Integer id);
}
