package com.example.studentmanagement.entity;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.*;
import lombok.*;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;


    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Student> students = new ArrayList<>(); // target student class

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Teacher> teachers = new ArrayList<>(); // target teacher class

    public void addStudent(Student student)
    {
        students.add(student);
        student.setDepartment(this);
    }
    public void addTeacher(Teacher teacher)
    {
        teachers.add(teacher);
        teacher.setDepartment(this);
    }
}