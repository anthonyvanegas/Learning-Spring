package com.app.cruddemo.dao;

import java.util.List;

import com.app.cruddemo.entity.Student;

public interface StudentDAO {

    void save(Student theStudent);

    Student findById(int theId);

    List<Student> findAll();

    List<Student> findByLastName(String theLastName);

    void update(Student theStudent);

    void delete(Integer id);

    int deleteAll(); 
}
