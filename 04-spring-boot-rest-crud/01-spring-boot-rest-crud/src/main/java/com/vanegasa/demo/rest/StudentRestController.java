package com.vanegasa.demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vanegasa.demo.entity.Student;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;

    // Define @PostConstruct to load the student data only once
    @PostConstruct
    public void loadData() {
        students = new ArrayList<>();
        students.add(new Student("John", "Doe"));
        students.add(new Student("Jane", "Smith"));
        students.add(new Student("Michael", "Johnson"));
    }

    // Define endpoint for "/students" that returns a list of students
    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    // Define endpoint for "/students/{studentId}" that returns a student by ID
    @GetMapping("/students/{studentId}")
    public Student getStudentById(@PathVariable int studentId) {
        if (studentId >= 0 && studentId < students.size()) {
            return students.get(studentId);
        } else {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }
    }

}
