package com.bxbro.summer.common.resp;

import com.bxbro.summer.common.constant.SystemEnum;

import java.io.Serializable;

/**
 * @Description 前端响应体 统一封装
 * @Author dong
 * @Date 2020/11/21
 */
public class BaseResponse<T> implements Serializable {

    private int code = SystemEnum.SUCCESS.getCode();

    private String msg = SystemEnum.SUCCESS.getDesc();

    private T data;

    public BaseResponse(){}

    public BaseResponse(T data) {
        this.code = SystemEnum.SUCCESS.getCode();
        this.msg = SystemEnum.SUCCESS.getDesc();
        this.data = data;
    }

    public BaseResponse(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <R> BaseResponse<R> success(){
        return new BaseResponse<>(SystemEnum.SUCCESS.getCode(), SystemEnum.SUCCESS.getDesc(), null);
    }

    public static <R> BaseResponse<R> success(R data) {
        return new BaseResponse<>(data);
    }

    public static BaseResponse<String> successMsg(String msg) {
        return new BaseResponse<>(SystemEnum.SUCCESS.getCode(), msg, null);
    }

    public static <R> BaseResponse<R> fail(){
        return new BaseResponse<>(SystemEnum.FAIL.getCode(), SystemEnum.FAIL.getDesc(), null);
    }

    public static BaseResponse fail(String msg) {
        return new BaseResponse<>(SystemEnum.FAIL.getCode(), msg, null);
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
