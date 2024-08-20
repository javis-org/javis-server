package com.javis.aplication.exception;

import com.javis.aplication.common.BusinessException;
import com.javis.aplication.common.ErrorCode;

public abstract class MemberException extends BusinessException {
    public MemberException(ErrorCode errorCode) {
        super(errorCode);
    }

    public static class MemberNotFoundException extends MemberException {
        public MemberNotFoundException() {
            super(MemberErrorCode.MEMBER_NOT_FOUND);
        }
    }

    public static class MEMBER_EMAIL_CONFLICT extends MemberException {
        public MEMBER_EMAIL_CONFLICT() {
            super(MemberErrorCode.MEMBER_EMAIL_CONFLICT);
        }
    }

}
