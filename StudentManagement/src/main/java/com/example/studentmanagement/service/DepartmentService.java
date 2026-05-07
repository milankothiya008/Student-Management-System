package com.example.studentmanagement.service;

import com.example.studentmanagement.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class DepartmentService {
    private DepartmentRepository departmentRepository;
    @Autowired
    public DepartmentService (DepartmentRepository departmentRepository)
    {
        this.departmentRepository= departmentRepository;
    }

}
