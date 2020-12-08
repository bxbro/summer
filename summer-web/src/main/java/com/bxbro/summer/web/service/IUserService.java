package com.bxbro.summer.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bxbro.summer.common.entity.User;
import com.bxbro.summer.web.vo.UserVO;

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
}
