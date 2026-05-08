package com.example.studentmanagement.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Teacher {
    @Id @GeneratedValue
    private Long id;

    @NotBlank(message= "name can not be blanck")
    private String name;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email cannot be blank")
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
}
