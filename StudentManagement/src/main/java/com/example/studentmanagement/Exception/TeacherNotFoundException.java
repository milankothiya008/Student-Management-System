package com.example.studentmanagement.Exception;

public class TeacherNotFoundException extends RuntimeException{
    public TeacherNotFoundException(String msg)
    {
        super(msg);
    }
}
