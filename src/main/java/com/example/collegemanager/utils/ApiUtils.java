package com.example.collegemanager.utils;

import com.example.collegemanager.Constants.ApiConstants;

public class ApiUtils {

    public static String getCurrentMethodName(){
        try {
            return Thread.currentThread().getStackTrace()[2].getMethodName();
        }catch (Exception cause){
            return ApiConstants.UNDEFINED;
        }
    }
}
