package com.javis.aplication.exception;

import com.javis.aplication.common.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum JobPostingErrorCode implements ErrorCode {
    JOB_POSTING_NOT_FOUND(HttpStatus.NOT_FOUND, "M001", "요청 게시물이 존재하지 않습니다."),
    ;

    private final HttpStatus status;
    private final String code;
    private String message;

}
