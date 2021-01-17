package com.bxbro.summer.study.dynamicproxy.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author dong
 * @description 调用处理器
 * @date 2021/1/16
 */
public class MySellHandler implements InvocationHandler {

    /**
     * 目标对象不能用UsbKingFactory，这样就把目标对象写死了
     * 而要用Object
     */
    public Object target = null;

    public MySellHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object res = null;

        // 1.调用代理方法
        res = method.invoke(target, args);

        // 2.功能增强
        if (res != null) {
            Float price = (Float) res;
            res = price + 25;
        }
        System.out.println("满100元，赠送一张优惠券");

        return res;
    }
}
