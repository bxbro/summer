package com.bxbro.web.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bxbro.common.entity.User;
import com.bxbro.web.mapper.UserMapper;
import com.bxbro.web.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  user 服务实现类
 * </p>
 *
 * @author auto-generator
 * @since 2020-12-05
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> selectUserList(int pageNo, int pageSize) {
        IPage<User> page = new Page<>(pageNo, pageSize);
        page = userMapper.selectPage(page, null);
        List<User> userList = page.getRecords();
        return userList;
    }
}
