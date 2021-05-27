package com.example.demo.model;

import com.example.demo.aop.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Member extends Mapper<Member> {
    @Column(name = "member_id")
    private long memberId;
    @Column(name = "member_name")
    private String name;
    @Column(name = "member_phone")
    private String phone;
    @Column(name = "member_sequence")
    private int sequence;
}
