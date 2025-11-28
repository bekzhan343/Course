package com.example.collegemanager.exceptions;

public class DataExistsException  extends  RuntimeException{

    public DataExistsException(String message){
        super(message);
    }
}
