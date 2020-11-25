package com.bxbro.common.resp;

import java.io.Serializable;

/**
 * @Description 前端响应体 统一封装
 * @Author dong
 * @Date 2020/11/21
 */
public class BaseResponse<T> implements Serializable {

    private int code = StatusCode.SUCCESS;

    private String msg = StatusMsg.SUCCESS;

    private T data;

    public BaseResponse(){}

    public BaseResponse(T data) {
        this.code = StatusCode.SUCCESS;
        this.msg = StatusMsg.SUCCESS;
        this.data = data;
    }

    public BaseResponse(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <R> BaseResponse<R> success(){
        return new BaseResponse<>();
    }

    public static <R> BaseResponse<R> success(R data) {
        return new BaseResponse<>(data);
    }

    public static BaseResponse<String> successMsg(String msg) {
        return new BaseResponse<>(StatusCode.SUCCESS, msg, null);
    }

    public static BaseResponse fail(String msg) {
        return new BaseResponse<>(StatusCode.FAIL, msg, null);
    }

    public static BaseResponse fail(int statusCode, String msg) {
        return new BaseResponse<>(statusCode, msg, null);
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
