package com.example.studentmanagement.Exception;

public class StudentNotFoundException extends RuntimeException{
    public StudentNotFoundException(String msg)
    {
        super(msg);
    }
}