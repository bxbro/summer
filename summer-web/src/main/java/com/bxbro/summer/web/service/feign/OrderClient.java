package com.bxbro.summer.web.service.feign;

import com.bxbro.summer.common.resp.BaseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "summer-order")
public interface OrderClient {


    @GetMapping("/order/{id}")
    BaseResponse getOrderById(@PathVariable("id") Integer id);
}
