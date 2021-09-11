package com.bxbro.summer.web.controller;

import com.bxbro.summer.common.domain.entity.User;
import com.bxbro.summer.web.service.impl.ComputeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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


    @ApiOperation(value = "跟夏天打个招呼")
    @GetMapping("/summer")
    public String sayHello() {
        List<String> services = discoveryClient.getServices();
        List<ServiceInstance> instances = discoveryClient.getInstances("summer-eureka-server");

        return "Hello Summer~";
    }


    @ApiOperation("ribbon调用summer-compute服务的计算接口")
    @GetMapping("/compute")
    public Integer getComputeResult(@RequestParam("a")Integer a,
                                    @RequestParam("b")Integer b) {
        StringBuilder serviceUrl = new StringBuilder();
        serviceUrl.append("http://summer-compute/compute?");
        serviceUrl.append("a=").append(a);
        serviceUrl.append("&b=").append(b);

        return restTemplate.getForEntity(serviceUrl.toString(), Integer.class).getBody();
    }

    @ApiOperation("ribbon调用summer-compute服务的计算接口, 增加了断路器")
    @GetMapping("/compute2")
    public Integer getComputeResult2(Integer a, Integer b) {
        return computeService.simpleCompute(a, b);
    }



}
