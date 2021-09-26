package com.bxbro.summer.common.util;

import com.bxbro.summer.common.exception.SummerException;
import com.bxbro.summer.common.resp.SystemEnum;

/**
 * @author dong
 * @description TODO
 * @date 2021/9/25
 */
public class AssertUtils {

    public static void notNull(Object object, String name) {
        if (object == null) {
            throw new SummerException(SystemEnum.FAIL.getCode(), name);
        }
    }
}
