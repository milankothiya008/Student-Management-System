package com.example.studentmanagement.controller;

import com.example.studentmanagement.entity.Student;
import com.example.studentmanagement.service.StudentService;
import jakarta.persistence.Temporal;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@RestController
@RequestMapping("/student")
public class Studentcontroller {
    private StudentService studentService;
    @Autowired
    public Studentcontroller(StudentService studentService)
    {
        this.studentService= studentService;
    }
    @GetMapping
    public ResponseEntity<List<Student>> findall()    {
        return ResponseEntity.ok(studentService.findAll());
    }
    @PostMapping("/save")
    public ResponseEntity<Student> save(  @Valid @RequestBody Student student)
    {
        return ResponseEntity.ok(studentService.save(student));
    }

    @PutMapping("/update")
    public ResponseEntity<Student> update(  @Valid @RequestBody Student student)
    {
        Long id= student.getId();
        return ResponseEntity.ok(studentService.update(id,student));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void>  delete(@PathVariable Long id)
    {
        studentService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<Student> findbyid(@PathVariable Long id)
    {
        return ResponseEntity.ok(studentService.findbyid(id));
    }
    @GetMapping("/email/{email}")
    public ResponseEntity<Student> findbyemail(@PathVariable String email)
    {
        return ResponseEntity.ok(studentService.findbyemail(email));
    }
}
