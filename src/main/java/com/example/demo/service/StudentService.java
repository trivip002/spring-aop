package com.example.demo.service;

import com.example.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Student> getListStudent() {
        return jdbcTemplate.query("SELECT * FROM student", new Student());
    }
}
