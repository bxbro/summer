package com.bxbro.summer.study.methodproxy;

import com.bxbro.summer.study.methodproxy.service.IHelloService;
import com.bxbro.summer.study.methodproxy.service.impl.HelloServiceImpl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author dong
 * @description java.lang.reflect包下 Method类 的使用方式
 * @date 2021/1/16
 */
public class Main {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException,
            IllegalAccessException {
        IHelloService helloService = new HelloServiceImpl();
        Method method = IHelloService.class.getMethod("sayHello", String.class);
        method.invoke(helloService, "Miss Summer");
    }

}
