package com.example.collegemanager.controller;

import com.example.collegemanager.constants.ApiMessage;
import com.example.collegemanager.service.CourseService;
import com.example.collegemanager.dto.course.CourseDTO;
import com.example.collegemanager.response.IamResponse;
import com.example.collegemanager.utils.ApiUtils;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("${end.point.course}")
public class CourseController {

    private final CourseService courseService;

    @GetMapping("${end.point.id}")
    public ResponseEntity<IamResponse<CourseDTO>> getCourseById(@PathVariable("id") Integer id){
        IamResponse<CourseDTO> response = courseService.getCourseByID(id);

        log.trace(ApiMessage.CURRENT_METHOD_NAME.getValue(), ApiUtils.getCurrentMethodName());

        log.info(ApiMessage.COURSE_INFO_BY_IF.getValue(),id);

        return ResponseEntity.ok(response);
    }

    @PostMapping("${end.point.create}")
    public ResponseEntity<IamResponse<CourseDTO>> createCourse(@RequestBody @Valid CourseDTO courseDTO){
        IamResponse<CourseDTO> iamResponse = courseService.createCourse(courseDTO);

        log.trace(ApiMessage.CURRENT_METHOD_NAME.getValue(), ApiUtils.getCurrentMethodName());
        log.info(ApiMessage.COURSE_INFO_BY_IF.getValue(), courseDTO.getId());
        return ResponseEntity.ok(iamResponse);
    }

    @PutMapping("${end.point.update.id}")
    public ResponseEntity<IamResponse<CourseDTO>> updateCourse(@PathVariable("id") Integer id, @RequestBody @Valid CourseDTO dto){
        IamResponse<CourseDTO> response = courseService.updateCourse(id, dto);

        log.trace(ApiMessage.CURRENT_METHOD_NAME.getValue(), ApiUtils.getCurrentMethodName());

        return ResponseEntity.ok(response);
    }
}
