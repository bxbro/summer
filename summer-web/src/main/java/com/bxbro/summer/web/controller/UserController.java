package com.bxbro.summer.web.controller;


import cn.hutool.core.bean.BeanUtil;
import com.bxbro.summer.common.constant.ResourceStatus;
import com.bxbro.summer.common.entity.User;
import com.bxbro.summer.common.resp.BaseResponse;
import com.bxbro.summer.common.resp.StatusCode;
import com.bxbro.summer.web.constant.UserConstant;
import com.bxbro.summer.web.param.UserParam;
import com.bxbro.summer.web.service.IUserService;
import com.bxbro.summer.web.vo.UserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  用户管理 前端控制器
 * </p>
 *
 * @author auto-generator
 * @since 2020-12-05
 */
@Api(value = "用户管理", tags = "用户管理模块")
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private IUserService userService;

    @ApiOperation(value = "新增用户")
    @PostMapping
    public BaseResponse saveUser(UserParam userParam) {
        if (StringUtils.isEmpty(userParam.getUserName()) || StringUtils.isEmpty(userParam.getPassword())) {
            return BaseResponse.fail("用户名或密码为空");
        }
        userService.saveUser(userParam);
        return BaseResponse.success(StatusCode.SUCCESS);
    }

    @ApiOperation(value = "编辑用户")
    @PutMapping
    public BaseResponse updateUser(UserParam userParam) {
        if (userParam.getId() == null) {
            return BaseResponse.fail("未传用户id");
        }
        User oldUser = userService.getById(userParam.getId());
        if (oldUser != null) {
            BeanUtil.copyProperties(userParam, oldUser);
            userService.saveOrUpdate(oldUser);
        } else {
            return BaseResponse.fail("该id对应的用户不存在！");
        }
        return BaseResponse.success(StatusCode.SUCCESS);
    }

    @ApiOperation(value = "分页查询用户列表")
    @GetMapping
    public BaseResponse<List<UserVO>> listUsers(@ApiParam(value = "页码") @RequestParam("pageNo") int pageNo,
                                                  @ApiParam(value = "每页显示条数") @RequestParam("pageSize") int pageSize) {
        List<UserVO> userVOList = userService.listUsers(pageNo, pageSize);
        return BaseResponse.success(userVOList);
    }


    @ApiOperation(value = "删除单个用户-软删除")
    @DeleteMapping("/{id}")
    public BaseResponse deleteUser(@ApiParam(value = "用户id") @PathVariable("id") Long id) {
        if (id == null) {
            return BaseResponse.fail("未传用户id");
        }
        User user = userService.getById(id);
        if (user == null) {
            return BaseResponse.fail("该id不正确，没有找到相应的用户");
        }
        user.setDeleted(ResourceStatus.DELETED);
        boolean result = userService.updateById(user);
        if (result) {
            return BaseResponse.success(StatusCode.SUCCESS);
        } else {
            return BaseResponse.success(StatusCode.FAIL);
        }
    }


}

