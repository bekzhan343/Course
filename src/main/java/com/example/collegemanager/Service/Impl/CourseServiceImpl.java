package com.example.collegemanager.Service.Impl;

import com.example.collegemanager.Constants.ApiErrorMessage;
import com.example.collegemanager.Entity.Course;
import com.example.collegemanager.Repository.CourseRepository;
import com.example.collegemanager.Service.CourseService;
import com.example.collegemanager.dto.course.CourseDTO;
import com.example.collegemanager.exceptions.NotFoundException;
import com.example.collegemanager.response.CourseResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Override
    public CourseResponse<CourseDTO> getCourseByID(@NonNull Integer id) {
        Course course = courseRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException(ApiErrorMessage.ERROR_MESSAGE_BY_ID.getMessage(id)));

        CourseDTO courseDTO = CourseDTO.builder()
                .id(course.getId())
                .name(course.getName())
                .teacher(course.getTeacher())
                .build();

        return CourseResponse.createdSuccessFully(courseDTO);
    }
}
