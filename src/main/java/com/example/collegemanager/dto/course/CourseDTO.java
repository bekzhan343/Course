package com.example.collegemanager.dto.course;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.io.Serializable;

@Getter
@AllArgsConstructor
@Data
@Builder
public class CourseDTO implements Serializable {

    private Integer id;
    private String name;
    private String teacher;
}
