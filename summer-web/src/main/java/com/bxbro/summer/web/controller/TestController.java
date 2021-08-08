package com.bxbro.summer.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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


    @ApiOperation(value = "跟夏天打个招呼")
    @GetMapping("/summer")
    public String sayHello() {
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

}
