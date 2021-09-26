package com.bxbro.summer.web.service.impl;

import com.bxbro.summer.common.resp.BaseResponse;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author dong
 * @description 测试Hystrix请求合并器
 * @date 2021/9/20
 */
@Service
public class OrderService {

    @Autowired
    RestTemplate restTemplate;


    @HystrixCollapser(batchMethod = "getOrders", collapserProperties = {
            @HystrixProperty(name = "timerDelayInMilliseconds", value = "100")
    })
    public BaseResponse getOrder(Integer id) {
        // 你会发现根本不会进入这个方法
        return null;
    }


    /**
     * 真正执行的方法
     * @param ids
     * @return
     */
    @HystrixCommand
    public BaseResponse getOrders(List<Integer> ids) {
        return restTemplate.getForObject(
                "http://SUMMER-ORDER/order?ids={1}", BaseResponse.class, StringUtils.join(ids, ","));
    }
}
