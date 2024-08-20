package com.javis.aplication.dto;

import com.javis.aplication.entity.MemberEntity;

public record RegisterRequestDto(
        String email,
        String password,
        String name
) {

    public MemberEntity toMemberEntity() {
        return MemberEntity.builder()
                .email(email)
                .password(password)
                .name(name)
                .build();
    }

}
