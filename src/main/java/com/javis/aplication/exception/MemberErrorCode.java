package com.javis.aplication.exception;

import com.javis.aplication.common.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum MemberErrorCode implements ErrorCode {
    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND, "M001", "요청 유저가 존재하지 않습니다."),
    MEMBER_EMAIL_CONFLICT(HttpStatus.CONFLICT, "M002", "이메일이 중복됩니다.")
    ;

    private final HttpStatus status;
    private final String code;
    private String message;

}
