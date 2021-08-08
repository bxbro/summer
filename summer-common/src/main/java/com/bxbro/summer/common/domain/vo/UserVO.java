package com.bxbro.summer.common.domain.vo;

/**
 * @Description TODO
 * @Author dong
 * @Date 2020/12/6
 */
public class UserVO {

    /**
     * 主键id
     */
    private Long id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * {@link com.bxbro.summer.web.common.constant.UserConstant.Gender}
     */
    private String genderStr;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 联系方式
     */
    private String phone;

    /**
     * 住址
     */
    private String address;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 创建时间
     */
    private Long ctime;

    /**
     * 修改时间
     */
    private Long mtime;

    /**
     * {@link com.bxbro.summer.common.constant.ResourceStatus}
     */
    private Integer deleted;

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

    public String getGenderStr() {
        return genderStr;
    }

    public void setGenderStr(String genderStr) {
        this.genderStr = genderStr;
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

    public Long getCtime() {
        return ctime;
    }

    public void setCtime(Long ctime) {
        this.ctime = ctime;
    }

    public Long getMtime() {
        return mtime;
    }

    public void setMtime(Long mtime) {
        this.mtime = mtime;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", genderStr='" + genderStr + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", ctime=" + ctime +
                ", mtime=" + mtime +
                ", deleted=" + deleted +
                '}';
    }
}
