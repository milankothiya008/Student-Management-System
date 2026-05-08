package com.example.studentmanagement.service;
import com.example.studentmanagement.Exception.DepartmentNotFoundException;
import com.example.studentmanagement.Exception.StudentNotFoundException;
import com.example.studentmanagement.entity.Department;
import com.example.studentmanagement.entity.Student;
import com.example.studentmanagement.repository.DepartmentRepository;
import com.example.studentmanagement.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class StudentService {
    private final StudentRepository studentrepository;
    private final DepartmentRepository departmentRepository;

    //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


    @Autowired
    public StudentService(StudentRepository studentRepository, DepartmentRepository departmentRepository)
    {
        this.studentrepository=studentRepository;
        this.departmentRepository= departmentRepository;
    }
    // -----------------------------------------------------------------------------------------------------------------------------------------------------------
    @Transactional
    public Student save(Student student)
    {
        Department dept= student.getDepartment();
        if(student.getDepartment() == null)
        {
            throw new RuntimeException("Department is required");
        }
        Long deptId= dept.getId();
        dept =departmentRepository.findById(deptId).orElseThrow(()-> new DepartmentNotFoundException("department not found by id: "+ deptId));
        dept.addStudent(student);
        return  studentrepository.save(student);
    }

    //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    public List<Student> findAll()
    {
         return studentrepository.findAll();

    }

    //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    public Student findbyid(Long id)
    {
        return studentrepository.findById(id).orElseThrow(()->new StudentNotFoundException("Student not found by Id: "+ id));
    }

    //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public Student findbyemail(String email)
    {
        return studentrepository.findByEmail(email).orElseThrow(() ->
                new StudentNotFoundException(
                        "Student not found with email: " + email
                ));
    }

    //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    @Transactional
    public Student update(Long id, Student updatedStudent)
    {
        Student student = studentrepository.findById(id).orElseThrow(()-> new StudentNotFoundException("Student not found of this id: "+ id));
        student.setName(updatedStudent.getName());
        student.setEmail(updatedStudent.getEmail());
        return studentrepository.save(student);
    }

    //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    @Transactional
    public void  delete(Long id)
    {
        Student student= studentrepository.findById(id).orElseThrow(()->new StudentNotFoundException("Student not exist by Id: "+ id));
         studentrepository.delete(student);
    }

    //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    public boolean existsById(Long id)
    {
        return studentrepository.existsById(id);
    }
    

}
