package com.bxbro.summer.web.service;

import com.bxbro.summer.common.entity.UserLock;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author auto-generator
 * @since 2020-12-18
 */
public interface IUserLockService extends IService<UserLock> {
    /**
     *@Description 根据userId查询userLock
     *@Author dong
     *@Date 2020/12/18
     */
    UserLock getUserLockByUserId(Long userId);
}
