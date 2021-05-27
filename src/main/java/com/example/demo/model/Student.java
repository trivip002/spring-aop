package com.example.demo.model;

import com.example.demo.aop.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class Student extends Mapper<Student> {
    private static final long serialVersionUID = 8889260784883898174L;
    @Column(name = "student_id")
    private long id;
    @Column(name = "student_name")
    private String studentName;
    @Column(name = "student_code")
    private String studentCode;
    @Column(name = "created_date")
    private Date createdDate;
}
