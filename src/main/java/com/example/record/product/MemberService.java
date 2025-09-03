package com.example.record.product;

import com.example.record.product.dto.MemberLoginReqDto;
import com.example.record.product.dto.MemberLoginResDto;
import com.example.record.product.dto.MemberRegisterReqDto;
import com.example.record.product.dto.MemberRegisterResDto;
import com.example.record.product.exception.DuplicatedMemberException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public MemberRegisterResDto registerMember(MemberRegisterReqDto memberRegisterReqDto) {
        String inputId = memberRegisterReqDto.getId();
        if (memberRepository.isExistMember(inputId)) {
            throw new DuplicatedMemberException("회원 중복");
        }
        Member member = memberRegisterReqDto.toMember();
        memberRepository.saveMember(member);
        return new MemberRegisterResDto(member.getName());
    }

    public MemberLoginResDto loginMember(MemberLoginReqDto memberLoginReqDto) {
        Member member = memberRepository.findByIdAndPassword(memberLoginReqDto);
        return new MemberLoginResDto(member.getId());
    }
}
