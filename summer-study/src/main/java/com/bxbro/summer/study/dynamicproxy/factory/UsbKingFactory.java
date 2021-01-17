package com.bxbro.summer.study.dynamicproxy.factory;

import com.bxbro.summer.study.dynamicproxy.service.IUsbSellService;

/**
 * @author dong
 * @description 目标类--金士顿厂家
 * @date 2021/1/16
 */
public class UsbKingFactory implements IUsbSellService {

    @Override
    public float sell(Integer count) {
        return 100.5f;
    }
}
