package com.example.record.product;

import com.example.record.product.Dto.MemberLoginReqDto;
import com.example.record.product.Dto.MemberLoginResDto;
import com.example.record.product.Dto.MemberRegisterReqDto;
import com.example.record.product.Dto.MemberRegisterResDto;
import com.example.record.product.utils.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping(value = "/register")
    public ApiResponse<MemberRegisterResDto> registerMember(@RequestBody MemberRegisterReqDto member) {
        return ApiResponse.success(memberService.registerMember(member));
    }

    @PostMapping(value = "/login")
    public ApiResponse<MemberLoginResDto> loginMember(@RequestBody MemberLoginReqDto member) {
        return ApiResponse.success(memberService.loginMember(member));
    }
}
