package com.example.studentmanagement.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student {

     @Id
     @GeneratedValue
     private long id;

     @NotBlank(message= "name can not be blanck")
     private String name;

     @Email(message = "Invalid email format")
     @NotBlank(message = "Email cannot be blank")
     private String email;

     @OneToOne(cascade = CascadeType.ALL)
     @JoinColumn(name="user_id") // control relationship
     private User user;

     @ManyToOne(fetch = FetchType.LAZY)
     @JoinColumn(name="department_id")
     private Department department;
}
