package com.example.collegemanager.dto.course;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @NotNull(message = "id cannot be empty!")
    private Integer id;
    @NotBlank(message = "name cannot be empty!")
    private String name;
    @NotBlank(message = "teacher cannot be empty!")
    private String teacher;
}
