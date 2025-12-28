package com.luv2code.demo.rest;

import com.luv2code.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private final List<Student> theStudents = new ArrayList<>();

    // define @PostConstruct to load data

    @PostConstruct
    private void loadData(){
        theStudents.add(new Student("John", "Doe"));
        theStudents.add(new Student("Jane", "Doe"));
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return theStudents;
    }

    // define endpoint or "/students/{studentId}" - return student at index
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        if (studentId < 0 || studentId >= theStudents.size()) {
            throw new StudentNotFoundException("Student not found with id: " + studentId);
        }

        return theStudents.get(studentId);
    }

}
