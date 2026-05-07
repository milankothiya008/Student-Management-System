package com.example.studentmanagement.service;

import com.example.studentmanagement.entity.Teacher;
import com.example.studentmanagement.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class TeacherService {
    private final TeacherRepository teacherRepository;
    @Autowired
    public TeacherService(TeacherRepository teacherRepository)
    {
        this.teacherRepository= teacherRepository;
    }

    public Teacher save(Teacher teacher)
    {
        return teacherRepository.save(teacher);
    }



}
