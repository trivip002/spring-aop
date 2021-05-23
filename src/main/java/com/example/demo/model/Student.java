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
   /* public Student(ResultSet rs) throws SQLException {
        this.id = rs.getInt("student_id");
        this.studentCode = rs.getString("student_code");
        this.studentName = rs.getString("student_name");
    }*/
    @Key(column = "student_id")
    private long id;
    @Key(column = "student_name")
    private String studentName;
    @Key(column = "student_code")
    private String studentCode;
}
