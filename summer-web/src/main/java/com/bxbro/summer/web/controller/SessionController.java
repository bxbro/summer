package com.bxbro.summer.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bxbro.summer.common.entity.User;
import com.bxbro.summer.common.resp.BaseResponse;
import com.bxbro.summer.web.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name", username);
        User user = userService.getOne(queryWrapper);
        if (user == null) {
            return BaseResponse.fail("該用戶不存在");
        }
        String passwordMd5 = DigestUtils.md5DigestAsHex(password.getBytes());
        if (passwordMd5.equals(user.getPassword())) {
            // 寫入session
            HttpSession session = request.getSession();

            return BaseResponse.successMsg("登錄成功");
        }

        return BaseResponse.fail("登錄失敗");
    }

}
