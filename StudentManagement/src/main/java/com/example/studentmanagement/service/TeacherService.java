package com.example.studentmanagement.service;

import com.example.studentmanagement.Exception.DepartmentNotFoundException;
import com.example.studentmanagement.Exception.TeacherNotFoundException;
import com.example.studentmanagement.entity.Department;
import com.example.studentmanagement.entity.Teacher;
import com.example.studentmanagement.repository.DepartmentRepository;
import com.example.studentmanagement.repository.TeacherRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
@Service

public class TeacherService {
    private final TeacherRepository teacherRepository;
    private final DepartmentRepository departmentRepository;
    @Autowired
    public TeacherService(TeacherRepository teacherRepository, DepartmentRepository departmentRepository)
    {
        this.teacherRepository= teacherRepository;
        this.departmentRepository= departmentRepository;
    }
    @Transactional
    public Teacher save(Teacher teacher)
    {
        Department dept= teacher.getDepartment();
        String name= dept.getName();
        dept= departmentRepository.findById(dept.getId()).orElseThrow(()-> new DepartmentNotFoundException("Department not found: "+ name));
        dept.addTeacher(teacher);
        return teacherRepository.save(teacher);
    }

    public List<Teacher> findall()
    {
        return teacherRepository.findAll();
    }
    public Teacher findbyemail(String email)
    {
        return teacherRepository.findByEmail(email).orElseThrow(()->new TeacherNotFoundException(" teacher not found by this email: " + email));
    }
    public Teacher findbyid(Long id)
    {
        return teacherRepository.findById(id).orElseThrow(()->new TeacherNotFoundException("techar not found"));
    }
    @Transactional
    public Teacher update(Long id, Teacher updatedteacher)
    {
        Teacher teacher = teacherRepository.findById(id).orElseThrow(()->new TeacherNotFoundException("teacher not found: "+ id));
        teacher.setName(updatedteacher.getName());
        teacher.setEmail(updatedteacher.getEmail());
        teacherRepository.save(teacher);
        return teacher;
    }
    @Transactional
    public void delete(Long id)
    {
        Teacher teacher = teacherRepository.findById(id).orElseThrow(()-> new TeacherNotFoundException("teacher not found: "+ id));
        teacherRepository.delete(teacher);
    }
    public boolean exists(Long id)
    {
        return teacherRepository.existsById(id);
    }
}
