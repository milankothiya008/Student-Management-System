package com.example.studentmanagement.repository;


import com.example.studentmanagement.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
    List<Student> findByDepartmentId(Long DepartmentId);
    List<Student> findBynameContainingIgnoreCase(String name);
    List<Student> findById(long Id);
    Optional<Student> findByEmail(String email);
}
