package com.javis.aplication.service;

import com.javis.aplication.dto.request.LoginRequestDto;
import com.javis.aplication.dto.request.RegisterRequestDto;
import com.javis.aplication.entity.MemberEntity;
import com.javis.aplication.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Long save(RegisterRequestDto registerRequestDto) {
        memberRepository.findByEmail(registerRequestDto.email());
        return memberRepository.save(registerRequestDto.toMemberEntity()).getId();
    }

    public Long login(LoginRequestDto loginRequestDto) {
        return memberRepository.findByEmailAndPassword(loginRequestDto.email(), loginRequestDto.password()).getId();
    }

}
