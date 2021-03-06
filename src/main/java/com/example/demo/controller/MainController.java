package com.example.demo.controller;

import com.example.demo.service.StudentService;
import com.example.demo.service.AopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class MainController {
    @Autowired
    private AopService aopService;

    @Autowired
    private StudentService studentService;

    @GetMapping("/demo-aop")
    public Object getUser() {
        aopService.testAop("Tri");
        aopService.testAop2("Tri");
        return "";
    }

    @GetMapping("/get-data")
    public Object getStudent() {
        Map<String, Object> result = new HashMap<>();
        result.put("student", studentService.getListStudent());
        return result;
    }

}
