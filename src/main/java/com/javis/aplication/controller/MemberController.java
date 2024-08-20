package com.javis.aplication.controller;

import com.javis.aplication.dto.request.LoginRequestDto;
import com.javis.aplication.dto.request.RegisterRequestDto;
import com.javis.aplication.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
@Tag(name = "Member")
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "회원가입 API")
    public Long register(@RequestBody @Valid RegisterRequestDto registerRequestDto){
        return memberService.save(registerRequestDto);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "로그인 API")
    public Long login(@RequestBody @Valid LoginRequestDto loginRequestDto){
        return memberService.login(loginRequestDto);
    }

}
