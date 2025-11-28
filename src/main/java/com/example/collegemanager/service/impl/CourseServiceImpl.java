package com.example.collegemanager.service.impl;

import com.example.collegemanager.constants.ApiErrorMessage;
import com.example.collegemanager.entity.Course;
import com.example.collegemanager.exceptions.DataExistsException;
import com.example.collegemanager.map.EntityMapping;
import com.example.collegemanager.repository.CourseRepository;
import com.example.collegemanager.service.CourseService;
import com.example.collegemanager.dto.course.CourseDTO;
import com.example.collegemanager.exceptions.NotFoundException;
import com.example.collegemanager.map.DtoMapping;
import com.example.collegemanager.response.CourseResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final DtoMapping dtoMapping;
    private final EntityMapping entityMapping;


    @Override
    public CourseResponse<CourseDTO> getCourseByID(@NonNull Integer id) {
        Course course = courseRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException(ApiErrorMessage.ERROR_MESSAGE_BY_ID.getMessage(id)));

        CourseDTO courseDTO = dtoMapping.toDTO(course);

        return CourseResponse.createdSuccessfully(courseDTO);
    }

    @Override
    public CourseResponse<CourseDTO> createCourse(@NotNull CourseDTO courseDTO) {
        if (courseRepository.existsByName(courseDTO.getName())){
            throw new  DataExistsException(ApiErrorMessage.DATA_ALREADY_EXISTS_INFO.getMessage(courseDTO.getName()));
        }

        Course course = entityMapping.toEntity(courseDTO);

        courseRepository.save(course);

        return CourseResponse.createdSuccessfully(courseDTO);
    }
}
