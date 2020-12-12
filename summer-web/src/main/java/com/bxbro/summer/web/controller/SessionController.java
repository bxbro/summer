package com.bxbro.summer.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description 用户注册/登录/登出/注销
 * @Author dong
 * @Date 2020/12/12
 */
@Api(tags = "用户注册/登录/登出/注销")
@RestController
@RequestMapping("/api/v1/session")
public class SessionController {


    /**
     *@Description 登录方法： 1.验证 2.设置session
     *@Author dong
     *@Date 2020/12/12
     */
    @ApiOperation("用户登录")
    @PostMapping("/login")
    public void login(HttpRequest request, HttpResponse response) {

    }

}
