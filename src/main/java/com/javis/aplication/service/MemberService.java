package com.javis.aplication.service;

import com.javis.aplication.dto.RegisterRequestDto;
import com.javis.aplication.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Long save(RegisterRequestDto registerRequestDto) {
        return memberRepository.save(registerRequestDto.toMemberEntity()).getId();
    }

    public Long login(String email, String password) {
        return memberRepository.findByEmailAndPassword(email, password).getId();
    }

}
