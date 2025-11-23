package com.example.collegemanager.Controller;

import com.example.collegemanager.Service.CourseService;
import com.example.collegemanager.dto.course.CourseDTO;
import com.example.collegemanager.response.CourseResponse;
import lombok.NonNull;
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

    private final CourseService courseService;

    @GetMapping("${end.point.id}")
    public ResponseEntity<CourseResponse<CourseDTO>> getCourseById(@PathVariable("id") Integer id){
        CourseResponse<CourseDTO> response = courseService.getCourseByID(id);
        return ResponseEntity.ok(response);
    }



}
