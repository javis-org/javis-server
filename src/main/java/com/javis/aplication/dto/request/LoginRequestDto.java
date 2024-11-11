package com.javis.aplication.dto.request;

import com.javis.aplication.entity.MemberEntityV1;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

public record LoginRequestDto(
        @NotNull(message = "이메일은 필수 값입니다.")
        @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",
                message = "[test@naver.com] 형식을 지켜주세요.")
        @Schema(description = "이메일(형식을 맞춰주세요.)")
        @Length(max = 50)
        String email,

        @NotNull(message = "비밀번호는 필수 값입니다.")
        @Schema(description = "비밀번호입니다.")
        @Length(max = 20)
        String password
) {

    public MemberEntityV1 toMemberEntity() {
        return MemberEntityV1.builder()
                .email(email)
                .password(password)
                .build();
    }

}
