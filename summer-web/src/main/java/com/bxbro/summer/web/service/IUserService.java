package com.bxbro.summer.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bxbro.summer.common.entity.User;
import com.bxbro.summer.common.resp.BaseResponse;
import com.bxbro.summer.web.param.UserParam;
import com.bxbro.summer.web.vo.UserVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author auto-generator
 * @since 2020-12-05
 */
public interface IUserService extends IService<User> {

    /**
     *@Description 分页查询用户列表
     *@Author dong
     *@Date 2020/12/8
     */
    List<UserVO> listUsers(int pageNo, int pageSize);
    /**
     *@Description 新增用户
     *@Author dong
     *@Date 2020/12/8
     */
    void saveUser(UserParam userParam);
    /**
     *@Description 登录
     *@Author dong
     *@Date 2020/12/18
     */
    BaseResponse login(HttpServletRequest request, HttpServletResponse response);
}
