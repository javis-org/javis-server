package com.javis.aplication.controller;

import com.javis.aplication.dto.RegisterRequestDto;
import com.javis.aplication.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
    public Long register(@RequestBody RegisterRequestDto registerRequestDto){
        return memberService.save(registerRequestDto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "로그인 API")
    public Long login(@RequestParam String email, @RequestParam String password){
        return memberService.login(email, password);
    }

}
