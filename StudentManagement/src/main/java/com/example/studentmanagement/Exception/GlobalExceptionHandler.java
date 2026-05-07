package com.example.studentmanagement.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<Map<String, Object>>handleStudentNotFoundException(StudentNotFoundException ex)
    {
        return buildErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleDepartmentNotFoundException(DepartmentNotFoundException ex)
    {
        return buildErrorResponse(ex.getMessage(),HttpStatus.NOT_FOUND);
    }

    private ResponseEntity<Map<String, Object>> buildErrorResponse(String msg, HttpStatus status)
    {
        Map<String, Object> error= new HashMap<>();
        error.put("status:",status.value());
        error.put("error:",status.getReasonPhrase());
        error.put("message", msg);
        return new  ResponseEntity<>(error, status);

    }
}
