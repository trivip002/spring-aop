package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class AopService {

    public Object testAop(String userName) {
        //throw new IllegalArgumentException("Ex");
        return userName + "dep trai 1";
    }


    public Object testAop2(String userName) {
        //throw new IllegalArgumentException("Ex");
        return userName + "dep trai 2";
    }
}
