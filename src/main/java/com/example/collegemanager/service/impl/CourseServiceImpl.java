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
import com.example.collegemanager.response.IamResponse;
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
    public IamResponse<CourseDTO> getCourseByID(@NonNull Integer id) {
        Course course = courseRepository
                .findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new NotFoundException(ApiErrorMessage.INFO_NOT_FOUND.getMessage(id)));

        CourseDTO courseDTO = dtoMapping.toDTO(course);

        return IamResponse.createdSuccessfully(courseDTO);
    }

    @Override
    public IamResponse<CourseDTO> createCourse(@NotNull CourseDTO courseDTO) {
        if (courseRepository.existsByName(courseDTO.getName())) {
            throw new DataExistsException(ApiErrorMessage.DATA_ALREADY_EXISTS_INFO.getMessage(courseDTO.getName()));
        }

        Course course = entityMapping.toEntity(courseDTO);

        courseRepository.save(course);

        return IamResponse.createdSuccessfully(courseDTO);
    }

    @Override
    public IamResponse<CourseDTO> updateCourse(@NotNull Integer id, @NotNull CourseDTO courseDTO) {
        Course updated = courseRepository
                .findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new NotFoundException(ApiErrorMessage.INFO_NOT_FOUND.getMessage(id)));

        updated.setId(id);
        updated.setName(courseDTO.getName());
        updated.setTeacher(courseDTO.getTeacher());

        courseRepository.save(updated);

        return IamResponse.createdSuccessfully(courseDTO);

    }

    @Override
    public void softDelete(@NotNull Integer id) {
        Course course = courseRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new NotFoundException(ApiErrorMessage.INFO_NOT_FOUND.getMessage(id)));

        course.setDeleted(true);
        courseRepository.save(course);
    }
}
