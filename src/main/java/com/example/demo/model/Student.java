package com.example.demo.model;

import com.example.demo.aop.Key;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@NoArgsConstructor
public class Student implements Serializable {
    private static final long serialVersionUID = 8889260784883898174L;
    @Key(column = "student_id")
    private long id;
    @Key(column = "student_name")
    private String studentName;
    @Key(column = "student_code")
    private String studentCode;
    @Key(column = "phone_number")
    private String phoneNumber;
}
