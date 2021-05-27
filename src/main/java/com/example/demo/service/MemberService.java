package com.example.demo.service;

import com.example.demo.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Member> getListMember() {
        return jdbcTemplate.query("SELECT * FROM member", new Member());
    }
}
