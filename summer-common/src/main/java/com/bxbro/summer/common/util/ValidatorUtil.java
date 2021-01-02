package com.bxbro.summer.common.util;

import java.util.regex.Pattern;

/**
 * 校验器：利用正则表达式校验邮箱/手机号等等
 * @author dong
 * @date 2020/12/29
 */
public class ValidatorUtil {

    /**
     * 验证用户名(不包含中文和特殊字符)
     */
    public static final String REGEX_USERNAME = "^[a-zA-z]\\w{5,17}$";
    /**
     * 验证密码(不包含特殊字符)
     */
    public static final String REGEX_PASSWORD = "^[a-zA-z0-9]{8,18}$";
    /**
     * 验证手机号
     * 总结：第一位必定为1 第二位必定为3/5/8，其他位置的可以为0-9
     */
    public static final String REGEX_MOBILE = "^(1[0-9]{10}$)";
    /**
     * 验证邮箱
     */
    public static final String REGEX_EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
    /**
     * 验证汉字(1-9个汉字)
     */
    public static final String REGEX_CHINESE = "^[\u4e00-\u9fa5]{1,9}$";

    //todo 验证身份证
    public static final String REGEX_ID_CARD = "";
    /**
     * 验证URL
     */
    public static final String REGEX_URL = "http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?";
    // todo 验证IP地址
    public static final String REGEX_IP_ADDR = "";

    /**
     * 校验用户名
     * @param userName
     * @return
     */
    public static boolean isUserName(String userName){
        return Pattern.matches(REGEX_USERNAME, userName);
    }


}
