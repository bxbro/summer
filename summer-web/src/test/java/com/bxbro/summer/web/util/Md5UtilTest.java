package com.bxbro.summer.web.util;

import org.springframework.util.DigestUtils;

/**
 * @Description MD5是不可逆的，所以无法解密
 * @Author dong
 * @Date 2020/12/6
 */
public class Md5UtilTest {

    public static void main(String[] args) {
        String password = "12345";
        String passwordMd5 = DigestUtils.md5DigestAsHex(password.getBytes());
        System.out.println("MD5加密后：" + passwordMd5);
    }
}
