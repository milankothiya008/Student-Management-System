package com.example.studentmanagement.service;

import com.example.studentmanagement.Exception.DepartmentNotFoundException;
import com.example.studentmanagement.entity.Department;
import com.example.studentmanagement.repository.DepartmentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DepartmentService {
    private DepartmentRepository departmentRepository;
    @Autowired
    public DepartmentService (DepartmentRepository departmentRepository)
    {
        this.departmentRepository= departmentRepository;
    }
    @Transactional
    public Department save( Department department)
    {
        return departmentRepository.save(department);
    }
    public List<Department> findall()
    {
        return departmentRepository.findAll();
    }

    public Department findbyid( Long id)
    {
        return  departmentRepository.findById(id).orElseThrow(()->new DepartmentNotFoundException(" this deparment not found;"+ id));
    }
    @Transactional
    public Department update(Long id, Department department)
    {
        Department dept= departmentRepository.findById(id).orElseThrow(()->new DepartmentNotFoundException("department not found: "+ id));
        dept.setName(department.getName());
        departmentRepository.save(dept);
        return dept;
    }
    @Transactional
    public void delete(Long id)
    {
        departmentRepository.deleteById(id);
    }
    public boolean exists(Long id)
    {
        return departmentRepository.existsById(id);
    }
}
