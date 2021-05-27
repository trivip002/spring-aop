package com.example.demo.controller;

import com.example.demo.service.MemberService;
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

    @Autowired
    private MemberService memberService;

    @GetMapping("/get-user")
    public Object getUser() {
        return aopService.getUserByName("Tri");
    }

    @GetMapping("/get-data")
    public Object getStudent() {
        Map<String, Object> result = new HashMap<>();
        result.put("student", studentService.getListStudent());
        //result.put("member", memberService.getListMember());
        return result;
    }

}
