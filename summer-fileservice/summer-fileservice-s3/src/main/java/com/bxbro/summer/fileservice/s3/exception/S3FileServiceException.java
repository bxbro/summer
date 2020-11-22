package com.bxbro.summer.fileservice.s3.exception;

import com.bxbro.summer.fileservice.api.exception.FileServiceException;

public class S3FileServiceException extends FileServiceException {
    public S3FileServiceException() {
    }

    public S3FileServiceException(String message) {
        super(message);
    }

    public S3FileServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public S3FileServiceException(Throwable cause) {
        super(cause);
    }

    public S3FileServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
