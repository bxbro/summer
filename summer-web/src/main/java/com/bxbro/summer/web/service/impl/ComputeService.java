package com.bxbro.summer.web.service.impl;

import com.bxbro.summer.common.resp.StatusCode;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author dong
 * @description TODO
 * @date 2021/9/10
 */
@Service
public class ComputeService {

    @Autowired
    RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "computeFallback")
    public Integer simpleCompute(Integer a, Integer b) {
        StringBuilder serviceUrl = new StringBuilder();
        serviceUrl.append("http://summer-compute/compute?");
        serviceUrl.append("a=").append(a);
        serviceUrl.append("&b=").append(b);

        return restTemplate.getForEntity(serviceUrl.toString(), Integer.class).getBody();
    }

    public Integer computeFallback(Integer a, Integer b) {
        System.out.println("-----------------进入断路器回调方法-----------------");
        return StatusCode.FAIL;
    }
}
