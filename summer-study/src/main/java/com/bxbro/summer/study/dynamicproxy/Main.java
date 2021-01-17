package com.bxbro.summer.study.dynamicproxy;

import com.bxbro.summer.study.dynamicproxy.factory.UsbKingFactory;
import com.bxbro.summer.study.dynamicproxy.handler.MySellHandler;
import com.bxbro.summer.study.dynamicproxy.service.IUsbSellService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author dong
 * @description 动态代理的实现过程
 * @date 2021/1/16
 */
public class Main {

    public static void main(String[] args) {
        // 1.创建目标对象
        IUsbSellService factory = new UsbKingFactory();

        // 2.创建InvocationHandler对象
        InvocationHandler handler = new MySellHandler(factory);

        // 3.实例化代理类对象
        IUsbSellService proxy = (IUsbSellService) Proxy.newProxyInstance(factory.getClass().getClassLoader(),
                factory.getClass().getInterfaces(), handler);

        // 4.通过代理执行方法
        float price = proxy.sell(1);
        System.out.println(price);
    }
}
