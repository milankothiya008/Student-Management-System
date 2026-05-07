package com.example.studentmanagement.Exception;

import com.example.studentmanagement.repository.DepartmentRepository;

public class DepartmentNotFoundException extends RuntimeException{
    public DepartmentNotFoundException(String msg)
    {
        super(msg);
    }
}
