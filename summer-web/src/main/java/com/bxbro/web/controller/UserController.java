package com.bxbro.web.controller;


import cn.hutool.core.bean.BeanUtil;
import com.bxbro.common.constant.ResourceStatus;
import com.bxbro.common.entity.User;
import com.bxbro.common.resp.BaseResponse;
import com.bxbro.common.resp.StatusCode;
import com.bxbro.web.Param.UserParam;
import com.bxbro.web.service.IUserService;
import com.bxbro.web.vo.UserVO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
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
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private IUserService userService;

    @ApiOperation(value = "新增用户")
    @PostMapping
    public BaseResponse addUser(UserParam userParam) {
        User user = new User();
        BeanUtil.copyProperties(userParam, user);
        user.setCtime(System.currentTimeMillis());
        user.setMtime(System.currentTimeMillis());
        user.setDeleted(ResourceStatus.UNDELETED);
        userService.save(user);
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
    public BaseResponse<List<UserVO>> getUserList(@ApiParam(value = "页码") @RequestParam("pageNo") int pageNo,
                                                  @ApiParam(value = "每页显示条数") @RequestParam("pageSize") int pageSize) {
        List<User> userList = userService.selectUserList(pageNo, pageSize);
        List<UserVO> userVOList = new ArrayList<>();
        userList.forEach((e)->{
            UserVO vo = new UserVO();
            BeanUtil.copyProperties(e, vo);
            userVOList.add(vo);
        });
        return BaseResponse.success(userVOList);
    }


    @ApiOperation(value = "删除单个用户")
    @DeleteMapping("/{id}")
    public BaseResponse deleteUser(@ApiParam(value = "用户id") @PathVariable("id") Long id) {
        boolean result = userService.removeById(id);
        if (result) {
            return BaseResponse.success(StatusCode.SUCCESS);
        } else {
            return BaseResponse.success(StatusCode.FAIL);
        }
    }


}

