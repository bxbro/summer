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
    * 分页查询用户列表
    * @author dong
    * @date 2020/12/8
    * @param pageNo
    * @param pageSize
    * @return java.util.List<com.bxbro.summer.web.vo.UserVO>
    */
    List<UserVO> listUsers(int pageNo, int pageSize);
    /**
    * 新增用户
    * @author dong
    * @date 2020/12/8
    * @param userParam
    * @return void
    */
    void saveUser(UserParam userParam);
    /**
    * 登录
    * @author dong
    * @date 2020/12/18
    * @param request
    * @param response
    * @return com.bxbro.summer.common.resp.BaseResponse
    */
    BaseResponse login(HttpServletRequest request, HttpServletResponse response);
}
