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

     @Column(nullable = false)
     private String name;

     @Column(nullable= false)
     private String email;

     @OneToOne(cascade = CascadeType.ALL)
     @JoinColumn(name="user_id") // control relationship
     private User user;

     @ManyToOne(fetch = FetchType.LAZY)
     @JoinColumn(name="department_id")
     private Department department;
}
