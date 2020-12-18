package com.bxbro.summer.web.controller;

import com.bxbro.summer.common.resp.BaseResponse;
import com.bxbro.summer.web.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description 用户注册/登录/登出/注销
 * @Author dong
 * @Date 2020/12/12
 */
@Api(tags = "SessionController")
@RestController
@RequestMapping("/api/v1/session")
public class SessionController {

    @Autowired
    private IUserService userService;

    /**
     *@Description 登录方法： 1.验证 2.设置session
     *@Author dong
     *@Date 2020/12/12
     */
    @ApiOperation("用户登录")
    @PostMapping("/login")
    public BaseResponse login(HttpServletRequest request, HttpServletResponse response) {
        return userService.login(request, response);
    }


    @ApiOperation("用户登出")
    @PostMapping("/logout")
    public BaseResponse logout() {
        // todo
        return BaseResponse.success();
    }

}
