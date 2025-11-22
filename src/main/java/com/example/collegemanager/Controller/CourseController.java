package com.example.collegemanager.Controller;

import com.example.collegemanager.Constants.ApiErrorMessage;
import com.example.collegemanager.Constants.ApiMessage;
import com.example.collegemanager.Entity.Course;
import com.example.collegemanager.Repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("${end.point.course}")
public class CourseController {


    private final CourseRepository courseRepository;


    @GetMapping("${end.point.id}")
    public ResponseEntity<Course> getCourseByID(@PathVariable Integer id) {

        log.info(ApiMessage.COURSE_INFO_BY_IF.getMessage(id));


        return courseRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> {log.info(ApiErrorMessage.ERROR_MESSAGE_BY_ID.getMessage(id));
                return ResponseEntity.noContent().build();

                });
    }

}
