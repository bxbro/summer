package com.bxbro.summer.study.methodproxy.service.impl;

import com.bxbro.summer.study.methodproxy.service.IHelloService;
import com.bxbro.summer.web.service.IHelloService;

/**
 * @author dong
 * @description TODO
 * @date 2021/1/16
 */
public class HelloServiceImpl implements IHelloService {
    @Override
    public void sayHello(String name) {
        System.out.println("hello, " + name + "这个冬天你好啊");
    }
}
