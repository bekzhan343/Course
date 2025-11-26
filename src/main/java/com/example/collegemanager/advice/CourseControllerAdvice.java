package com.example.collegemanager.advice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Objects;

@Slf4j
@ControllerAdvice
public class CourseControllerAdvice {

    @ExceptionHandler
    @ResponseBody
    protected ResponseEntity<String> handleNotFoundException(Exception ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ex.getMessage());
    }

}
