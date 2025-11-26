package com.example.collegemanager.service.impl;

import com.example.collegemanager.constants.ApiErrorMessage;
import com.example.collegemanager.entity.Course;
import com.example.collegemanager.repository.CourseRepository;
import com.example.collegemanager.service.CourseService;
import com.example.collegemanager.dto.course.CourseDTO;
import com.example.collegemanager.exceptions.NotFoundException;
import com.example.collegemanager.map.CourseMapping;
import com.example.collegemanager.response.CourseResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapping courseMapping;

    @Override
    public CourseResponse<CourseDTO> getCourseByID(@NonNull Integer id) {
        Course course = courseRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException(ApiErrorMessage.ERROR_MESSAGE_BY_ID.getMessage(id)));

        CourseDTO courseDTO = courseMapping.toDTO(course);

        return CourseResponse.createdSuccessfully(courseDTO);
    }
}
