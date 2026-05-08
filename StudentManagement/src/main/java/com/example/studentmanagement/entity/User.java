package com.example.studentmanagement.entity;
import jakarta.persistence.*;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.*;
import javax.annotation.processing.Generated;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "users")
public class User {
    @Id
    @GeneratedValue
    private long Id;

    @Column(unique=true,nullable=false)
    private String username;

    @Column(unique=true, nullable=false)

    private String password;

    @Enumerated(EnumType.STRING)
    private String role;
}
