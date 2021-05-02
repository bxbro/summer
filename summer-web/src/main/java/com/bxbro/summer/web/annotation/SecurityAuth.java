package com.bxbro.summer.web.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author dong
 * @description TODO
 * @date 2021/4/9
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SecurityAuth {
    /**
     * 拥有权限的角色名
     * @return
     */
    String roleName();
}
