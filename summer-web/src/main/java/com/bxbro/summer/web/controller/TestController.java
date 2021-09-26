package com.bxbro.summer.web.controller;

import com.bxbro.summer.common.exception.SummerException;
import com.bxbro.summer.common.resp.BaseResponse;
import com.bxbro.summer.common.constant.SystemEnum;
import com.bxbro.summer.web.service.feign.OrderClient;
import com.bxbro.summer.web.service.impl.ComputeService;
import com.bxbro.summer.web.service.impl.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Description TODO
 * @Author dong
 * @Date 2020/11/21
 */
@Api(value = "HelloTest", tags = "Hello测试")
@RestController
@RequestMapping("/api/v1/test")
public class TestController {

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    DiscoveryClient discoveryClient;
    @Autowired
    ComputeService computeService;
    @Autowired
    OrderService orderService;
    @Autowired
    OrderClient orderClient;


    @ApiOperation(value = "获取服务注册中心实例")
    @GetMapping("/summer")
    public String sayHello() {
        List<String> services = discoveryClient.getServices();
        List<ServiceInstance> instances = discoveryClient.getInstances("summer-eureka-server");

        return "Hello Summer~";
    }


    @ApiOperation("ribbon调用summer-compute服务的计算接口")
    @GetMapping("/compute")
    public Integer getComputeResult(@RequestParam("a")Integer a, @RequestParam("b")Integer b) {
        StringBuilder serviceUrl = new StringBuilder();
        serviceUrl.append("http://summer-compute/compute?");
        serviceUrl.append("a=").append(a);
        serviceUrl.append("&b=").append(b);

        return restTemplate.getForEntity(serviceUrl.toString(), Integer.class).getBody();
    }

    @ApiOperation("ribbon调用summer-compute服务的计算接口, 增加了Hystrix服务降级处理")
    @GetMapping("/compute2")
    public Integer getComputeResult2(Integer a, Integer b) {
        return computeService.simpleCompute(a, b);
    }


    @ApiOperation("ribbon调用summer-order服务的获取订单接口，增加Hystrix的请求合并器")
    @GetMapping("/orders/{id}")
    public BaseResponse getOrderList(@PathVariable("id") Integer id) {
        if (id == null) {
            throw new SummerException(SystemEnum.PARAM_VALIDATE_ERROR.getCode(), SystemEnum.PARAM_VALIDATE_ERROR.getDesc());
        }
        return orderService.getOrder(id);
    }


    @ApiOperation("feign调用summer-order服务的获取订单接口")
    @GetMapping("/order/{id}")
    public BaseResponse getOrderById(@PathVariable("id") Integer id) {
        return orderClient.getOrderById(id);
    }

}
