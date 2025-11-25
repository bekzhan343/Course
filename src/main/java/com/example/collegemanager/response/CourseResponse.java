package com.example.collegemanager.response;



import java.io.Serializable;

public record CourseResponse<P extends Serializable>(
        String message,
        P payload,
        boolean success
)implements Serializable {
    public static <P extends Serializable> CourseResponse<P> createdSuccessfully(P payload){
        return new CourseResponse<>("DONE SUCCESSFULLY!",payload, true);
    }
}