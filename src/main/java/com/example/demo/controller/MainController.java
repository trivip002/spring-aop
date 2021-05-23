package com.example.demo.controller;

import com.example.demo.service.StudentService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MainController {
    @Autowired
    private UserService userService;

    @Autowired
    private StudentService studentService;

    @GetMapping("/get-user")
    public Object getUser() {
        return userService.getUserByName("Tri");
    }

    @GetMapping("/get-student")
    public Object getStudent() {
        return studentService.getListStudent();
    }

}
