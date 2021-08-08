package com.bxbro.summer.common.domain.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description TODO
 * @Author dong
 * @Date 2020/12/5
 */
@ApiModel("用户")
public class UserParam {

    /**
     * 主键id
     */
    @ApiModelProperty("主键id")
    private Long id;
    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    private String userName;

    /**
     * 密码
     */
    @ApiModelProperty("密码")
    private String password;

    /**
     * 性别
     */
    @ApiModelProperty("性别")
    private Integer gender;

    /**
     * 年龄
     */
    @ApiModelProperty("年龄")
    private Integer age;

    /**
     * 联系方式
     */
    @ApiModelProperty("联系方式")
    private String phone;

    /**
     * 住址
     */
    @ApiModelProperty("住址")
    private String address;

    /**
     * 电子邮箱
     */
    @ApiModelProperty("电子邮箱")
    private String email;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
