package com.javis.aplication.service;

import com.javis.aplication.dto.request.LoginRequestDto;
import com.javis.aplication.dto.request.RegisterRequestDto;
import com.javis.aplication.exception.MemberException.MEMBER_EMAIL_CONFLICT;
import com.javis.aplication.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Long save(RegisterRequestDto registerRequestDto) {
        if(memberRepository.findByEmail(registerRequestDto.email()).isPresent()) {
            throw new MEMBER_EMAIL_CONFLICT();
        }
        return memberRepository.save(registerRequestDto.toMemberEntity()).getId();
    }

    public Long login(LoginRequestDto loginRequestDto) {
        return memberRepository.findByEmailAndPassword(loginRequestDto.email(), loginRequestDto.password()).getId();
    }

}
