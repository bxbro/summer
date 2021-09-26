package com.bxbro.summer.common.resp;

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
    PARAM_VALIDATE_ERROR(1000, "参数校验失败.");

    private Integer code;
    private String desc;

}
