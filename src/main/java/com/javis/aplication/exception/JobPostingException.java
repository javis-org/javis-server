package com.javis.aplication.exception;

import com.javis.aplication.common.BusinessException;
import com.javis.aplication.common.ErrorCode;

public abstract class JobPostingException extends BusinessException {
    public JobPostingException(ErrorCode errorCode) {
        super(errorCode);
    }

    public static class JobPostingNotFoundException extends JobPostingException {
        public JobPostingNotFoundException() {
            super(JobPostingErrorCode.JOB_POSTING_NOT_FOUND);
        }
    }

}
