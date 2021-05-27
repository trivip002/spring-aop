package com.example.demo.model;

import com.example.demo.aop.Key;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Member {
    @Key(column = "member_id")
    private long memberId;
    @Key(column = "member_name")
    private String name;
    @Key(column = "member_phone")
    private String phone;
    @Key(column = "member_sequence")
    private int sequence;
}
