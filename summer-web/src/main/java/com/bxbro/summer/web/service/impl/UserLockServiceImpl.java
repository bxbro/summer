package com.bxbro.summer.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bxbro.summer.common.entity.UserLock;
import com.bxbro.summer.web.mapper.UserLockMapper;
import com.bxbro.summer.web.service.IUserLockService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author auto-generator
 * @since 2020-12-18
 */
@Service
public class UserLockServiceImpl extends ServiceImpl<UserLockMapper, UserLock> implements IUserLockService {

    @Autowired
    private UserLockMapper userLockMapper;

    @Override
    public UserLock getUserLockByUserId(Long userId) {
        QueryWrapper<UserLock> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        UserLock userLock = userLockMapper.selectOne(queryWrapper);
        return userLock;
    }
}
