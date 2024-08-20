package com.javis.aplication.common;

public record ErrorResponse(String errorCode, String message) {

    public static ErrorResponse from(BusinessException e) {
        return new ErrorResponse(e.getCode(), e.getMessage());
    }

}
