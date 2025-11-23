package com.example.collegemanager.Service;

import com.example.collegemanager.dto.course.CourseDTO;
import com.example.collegemanager.response.CourseResponse;
import lombok.NonNull;

public interface CourseService {

    CourseResponse<CourseDTO> getCourseByID(@NonNull Integer id);
}
