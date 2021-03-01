package com.bxbro.summer.study.stringprc;

/**
 * @author dong
 * @description TODO
 * @date 2021/3/1
 */
public class StringTest {

    /**
     * 主键生成策略
     * @param args
     */
    public static void main(String[] args) {
        int index = 111;
        String format = "pk_" + String.format("%010d", index);
        System.out.println(format);
    }
}
