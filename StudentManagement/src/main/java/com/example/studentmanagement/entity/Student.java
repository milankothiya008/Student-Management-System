package com.example.studentmanagement.entity;
import jakarta.persistence.*;
import lombok.*;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student {
     @Id
     @GeneratedValue
    private long id;

     private String name;
     private String email;

     @OneToOne
    @JoinColumn(name="user_id")
    private User user;

     @ManyToOne
    @JoinColumn(name="department_id")
    private Department department;
}
