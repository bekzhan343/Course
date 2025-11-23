package com.example.collegemanager.response;


import lombok.*;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseResponse<P extends Serializable> implements Serializable {

    private String message;
    private P payload;
    private boolean success;


    public static <P extends Serializable> CourseResponse<P> createdSuccessFully(P payload){
        return new CourseResponse<>(StringUtils.EMPTY, payload, true);
    }
}
