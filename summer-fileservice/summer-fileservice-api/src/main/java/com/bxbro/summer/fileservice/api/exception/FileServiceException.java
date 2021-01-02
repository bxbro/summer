package com.bxbro.summer.fileservice.api.exception;

/**
 *@Description 文件服务统一异常
 *@Author dong
 *@Date 2020/12/29
 */
public class FileServiceException extends RuntimeException {

    public FileServiceException() {
    }

    public FileServiceException(String message) {
        super(message);
    }

    public FileServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileServiceException(Throwable cause) {
        super(cause);
    }

    public FileServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
