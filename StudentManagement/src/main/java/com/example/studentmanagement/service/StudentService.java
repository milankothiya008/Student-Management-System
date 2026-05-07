package com.example.studentmanagement.service;

import com.example.studentmanagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentService {
    private StudentRepository studentrepository;
    @Autowired
    public StudentService(StudentRepository studentRepository)
    {
        this.studentrepository=studentRepository;
    }
}
