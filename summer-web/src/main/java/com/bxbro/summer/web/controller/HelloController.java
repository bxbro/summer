package com.bxbro.summer.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author dong
 * @Date 2020/11/21
 */
@Api(value = "HelloTest", tags = "Hello测试")
@RestController
@RequestMapping("/api/v1/test")
public class HelloController {

    @ApiOperation(value = "跟夏天打个招呼")
    @GetMapping("/summer")
    public String sayHello() {
        return "Hello Miss Summer~";
    }

}
