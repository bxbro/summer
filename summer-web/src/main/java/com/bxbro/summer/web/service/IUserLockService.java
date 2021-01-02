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
    * 根据userId查询userLock
    * @author dong
    * @date 2020/12/18
    * @param userId
    * @return com.bxbro.summer.common.entity.UserLock
    */
    UserLock getUserLockByUserId(Long userId);
}
