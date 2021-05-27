package com.example.demo.model;

import com.example.demo.aop.Column;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class Student {
    @Column(name = "student_id")
    private long id;
    @Column(name = "student_name")
    private String studentName;
    @Column(name = "student_code")
    private String studentCode;
    @Column(name = "created_date")
    private Date createdDate;
}
