package com.example.studentmanagement.controller;

import com.example.studentmanagement.entity.Teacher;
import com.example.studentmanagement.service.TeacherService;
import jakarta.validation.Valid;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@RestController
@RequestMapping("/teacher")
public class Teachercontroller {
    private final TeacherService teacherService;
    @Autowired
    public Teachercontroller(TeacherService teacherService)
    {
        this.teacherService= teacherService;
    }
    @GetMapping
    public ResponseEntity<List<Teacher>> findall()
    {
        return ResponseEntity.ok(teacherService.findall());
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<Teacher> findbyid(@PathVariable Long id)
    {
        return ResponseEntity.ok(teacherService.findbyid(id));
    }
    @GetMapping("/email/{email}")
    public ResponseEntity<Teacher> findbyemail(@PathVariable String email)
    {
        return ResponseEntity.ok(teacherService.findbyemail(email));
    }
    @PostMapping("/save")
    public ResponseEntity<Teacher> save( @Valid @RequestBody Teacher teacher)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(teacherService.save(teacher));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Teacher> update( @Valid @PathVariable Long id, @RequestBody Teacher teacher)
    {
        return ResponseEntity.ok(teacherService.update(id, teacher));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id)
    {
        teacherService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
