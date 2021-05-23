package com.example.demo.service;

import com.example.demo.aop.StudentMapper;
import com.example.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Object getListStudent() {
        return jdbcTemplate.query("SELECT * FROM student", (rs, i) -> StudentMapper.convertToObject(Student.class, rs));
    }

}
