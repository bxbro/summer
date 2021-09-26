package com.bxbro.summer.common.exception;

/**
 * @author dong
 * @description TODO
 * @date 2021/9/25
 */
public class SummerException extends RuntimeException {

    Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }


    public SummerException() {
        super();
    }

    public SummerException(String message) {
        super(message);
    }

    public SummerException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public SummerException(String message, Throwable cause) {
        super(message, cause);
    }

    public SummerException(Throwable cause) {
        super(cause);
    }

    protected SummerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
