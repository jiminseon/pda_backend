package com.example.record.product;

import com.example.record.product.Dto.MemberLoginReqDto;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Repository
public class MemberRepository {
    private final Map<Integer, Member> map = new HashMap<>();

    public MemberRepository() {
        map.put(1, new Member("jitory", "1234", "지민선", "ISTP"));
        map.put(2, new Member("jiyoi", "1234", "김지연", "ESTJ"));
    }

    public Member saveMember(Member member) {
        int id = map.isEmpty() ? 1 : Collections.max(map.keySet()) + 1;
        map.put(id, member);
        return member;
    }

    public Member findByIdAndPassword(MemberLoginReqDto member) {
        return map.values().stream()
                .filter(m -> m.getId().equals(member.getId()) && m.getPw().equals(member.getPw()))
                .findFirst()
                .orElse(null);
    }

    public boolean isExistMember(String inputId) {
        return map.values().stream()
                .anyMatch(m -> m.getId().equals(inputId));
    }
}
