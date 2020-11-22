package com.bxbro.summer.fileservice.local.exception;

import com.bxbro.summer.fileservice.api.exception.FileServiceException;


public class LocalFileServiceException extends FileServiceException {
    public LocalFileServiceException() {
    }

    public LocalFileServiceException(String message) {
        super(message);
    }

    public LocalFileServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public LocalFileServiceException(Throwable cause) {
        super(cause);
    }

    public LocalFileServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
