package com.bxbro.summer.common.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * <p>
 *   用户锁
 * </p>
 *
 * @author auto-generator
 * @since 2020-12-18
 */
@TableName("t_user_lock")
public class UserLock extends Model<UserLock> {

    private static final long serialVersionUID=1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 失败次数
     */
    private Integer failCount;

    /**
     * 登录时间
     */
    private String loginTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getFailCount() {
        return failCount;
    }

    public void setFailCount(Integer failCount) {
        this.failCount = failCount;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

    public static final String ID = "id";

    public static final String USER_NAME = "user_name";

    public static final String USER_ID = "user_id";

    public static final String FAIL_COUNT = "fail_count";

    public static final String LOGIN_TIME = "login_time";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "UserLock{" +
        "id=" + id +
        ", userName=" + userName +
        ", userId=" + userId +
        ", failCount=" + failCount +
        ", loginTime=" + loginTime +
        "}";
    }
}
