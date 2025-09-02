package com.example.record.product.Dto;

import com.example.record.product.Member;
import lombok.Getter;

@Getter
public class MemberRegisterReqDto {
    private String id;
    private String pw;
    private String name;
    private String mbti;

    public Member toMember() {
        return new Member(id, pw, name, mbti);
    }
}
