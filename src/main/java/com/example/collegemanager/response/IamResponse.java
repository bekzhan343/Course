package com.example.collegemanager.response;



import java.io.Serializable;

public record IamResponse<P extends Serializable>(
        String message,
        P payload,
        boolean success
)implements Serializable {
    public static <P extends Serializable> IamResponse<P> createdSuccessfully(P payload){
        return new IamResponse<>("DONE SUCCESSFULLY!",payload, true);
    }
}