package com.bxbro.summer.web.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bxbro.summer.common.constant.ResourceStatus;
import com.bxbro.summer.common.entity.User;
import com.bxbro.summer.common.entity.UserLock;
import com.bxbro.summer.common.resp.BaseResponse;
import com.bxbro.summer.common.util.DateUtil;
import com.bxbro.summer.web.constant.UserConstant;
import com.bxbro.summer.web.mapper.UserLockMapper;
import com.bxbro.summer.web.mapper.UserMapper;
import com.bxbro.summer.web.param.UserParam;
import com.bxbro.summer.web.service.IUserLockService;
import com.bxbro.summer.web.service.IUserService;
import com.bxbro.summer.web.vo.UserVO;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
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
    @Autowired
    private IUserLockService userLockService;


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

    @Override
    public BaseResponse login(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name", username);
        User user = userMapper.selectOne(queryWrapper);
        if (user == null) {
            return BaseResponse.fail("该用戶不存在");
        }
        String passwordMd5 = DigestUtils.md5DigestAsHex(password.getBytes());
        if (!passwordMd5.equals(user.getPassword())) {
            // 密码错误次数存入userlock表
            UserLock userLock = userLockService.getUserLockByUserId(user.getId());
            if (userLock == null) {
                UserLock newUserLock = new UserLock();
                newUserLock.setFailCount(1);
                newUserLock.setLoginTime(DateUtil.getDateTime(new Date()));
                newUserLock.setUserId(user.getId());
                newUserLock.setUserName(user.getUserName());
                userLockService.save(newUserLock);
            } else {
                if (userLock.getFailCount()>=3) {
                    return BaseResponse.fail("今日登录失败次数已达三次，请半小时后重试");
                }else {
                    userLock.setFailCount(userLock.getFailCount() + 1);
                    userLockService.saveOrUpdate(userLock);
                }
            }
            return BaseResponse.fail("密码错误");
        }

        // todo 登录成功后，写入session
        HttpSession session = request.getSession();
        session.setAttribute("loginUser", username);

        // todo 登录成功后，状态设为在线

        return BaseResponse.successMsg("登录成功");
    }
}
