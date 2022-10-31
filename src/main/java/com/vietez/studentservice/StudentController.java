package com.vietez.studentservice;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class StudentController {

    @Autowired
    private final StudentService studentService;

    @GetMapping("/students/{id}")
    Student getStudent(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    void studentNotFoundExcepption(StudentNotFoundException e)
    {

    }
}
