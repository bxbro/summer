package com.bxbro.summer.common.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author dong
 * @description TODO
 * @date 2021/9/26
 */
@Getter
@AllArgsConstructor
public enum SystemEnum {

    SUCCESS(0, "操作成功"),
    FAIL(-1, "操作失败"),
    PARAM_VALIDATE_ERROR(1000, "参数校验失败"),
    SERVICE_INVOCATION_ERROR(2000, "服务间调用失败"),
    SERVICE_UNAVAILABLE(2001, "服务暂时不可用");

    private Integer code;
    private String desc;

}
