package com.asc.exception;

public class DuplicateCourseException extends RuntimeException{
    public DuplicateCourseException(String message){
        super(message);
    }
}
