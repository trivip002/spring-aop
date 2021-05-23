package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public Object getUserByName(String userName) {
        throw new IllegalArgumentException("Ex");
        //return userName + "dep trai";
    }

}
