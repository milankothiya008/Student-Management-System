package com.example.studentmanagement.controller;

import com.example.studentmanagement.entity.Department;
import com.example.studentmanagement.service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class Departmentcontroller {
     private final DepartmentService departmentService;
     @Autowired
     public Departmentcontroller (DepartmentService departmentService)
     {
          this.departmentService = departmentService;
     }

     @GetMapping
     public ResponseEntity<List<Department>> findall()
     {
          return ResponseEntity.ok(departmentService.findall());
     }
     @GetMapping("/id/{id}")
     public ResponseEntity<Department> findbyid(@PathVariable Long id)
     {
          return ResponseEntity.ok(departmentService.findbyid(id));
     }
     @PostMapping

     public ResponseEntity<Department> save( @Valid @RequestBody Department department)
     {
          return ResponseEntity.status(HttpStatus.CREATED).body(departmentService.save(department));
     }

     @PutMapping("/update/{id}")

     public ResponseEntity<Department> update( @Valid @RequestBody Department department ,@PathVariable Long id)
     {
          return ResponseEntity.ok(departmentService.update(id,department));
     }

     @DeleteMapping("/delete/{id}")
     public ResponseEntity<Void> delete(@PathVariable Long id)
     {
          departmentService.delete(id);
          return ResponseEntity.noContent().build();
     }
}
