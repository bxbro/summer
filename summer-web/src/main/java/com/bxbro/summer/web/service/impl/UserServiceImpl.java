package com.bxbro.summer.web.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bxbro.summer.common.constant.ResourceStatus;
import com.bxbro.summer.common.entity.User;
import com.bxbro.summer.web.constant.UserConstant;
import com.bxbro.summer.web.mapper.UserMapper;
import com.bxbro.summer.web.param.UserParam;
import com.bxbro.summer.web.service.IUserService;
import com.bxbro.summer.web.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.ArrayList;
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
    public List<UserVO> listUsers(int pageNo, int pageSize) {
        IPage<User> page = new Page<>(pageNo, pageSize);
        page = userMapper.selectPage(page, null);
        List<User> userList = page.getRecords();
        List<UserVO> userVOList = new ArrayList<>();

        userList.forEach((e)->{
            UserVO vo = new UserVO();
            BeanUtil.copyProperties(e, vo);

            if (UserConstant.Gender.WOMEN.getCode().equals(e.getGender())) {
                vo.setGenderStr(UserConstant.Gender.WOMEN.getName());
            } else if (UserConstant.Gender.MAN.getCode().equals(e.getGender())) {
                vo.setGenderStr(UserConstant.Gender.MAN.getName());
            } else {
                vo.setGenderStr(UserConstant.Gender.UNKNOWN.getName());
            }
            userVOList.add(vo);
        });
        return userVOList;
    }

    @Override
    public void saveUser(UserParam userParam) {
        User user = new User();
        BeanUtil.copyProperties(userParam, user);
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        user.setCtime(System.currentTimeMillis());
        user.setMtime(System.currentTimeMillis());
        user.setDeleted(ResourceStatus.UNDELETED);
        userMapper.insert(user);
    }
}
