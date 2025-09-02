package com.example.record.product;

import lombok.Getter;

@Getter
public class Member {
    private final String id;
    private final String pw;
    private String name;
    private String mbti;

    public Member(String id, String pw, String name, String mbti) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.mbti = mbti;
    }

    public Member(String id, String pw) {
        this.id = id;
        this.pw = pw;
    }
}
