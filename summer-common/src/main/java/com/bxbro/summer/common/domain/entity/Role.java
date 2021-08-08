package com.bxbro.summer.common.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 *  角色实体类
 * </p>
 *
 * @author auto-generator
 * @since 2020-12-13
 */
@TableName("t_role")
public class Role extends Model<Role> {

    private static final long serialVersionUID=1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色类型
     */
    private Boolean roleType;

    /**
     * 角色的菜单权限
     */
    private String rolePermission;

    /**
     * 角色描述
     */
    private String description;

    /**
     * 创建时间
     */
    private Long ctime;

    /**
     * 修改时间
     */
    private Long mtime;

    /**
     * 是否删除标志位（0 未删除 1 已删除）
     */
    private Boolean deleted;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Boolean getRoleType() {
        return roleType;
    }

    public void setRoleType(Boolean roleType) {
        this.roleType = roleType;
    }

    public String getRolePermission() {
        return rolePermission;
    }

    public void setRolePermission(String rolePermission) {
        this.rolePermission = rolePermission;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public static final String ID = "id";

    public static final String ROLE_NAME = "role_name";

    public static final String ROLE_TYPE = "role_type";

    public static final String ROLE_PERMISSION = "role_permission";

    public static final String DESCRIPTION = "description";

    public static final String CTIME = "ctime";

    public static final String MTIME = "mtime";

    public static final String DELETED = "deleted";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Role{" +
        "id=" + id +
        ", roleName=" + roleName +
        ", roleType=" + roleType +
        ", rolePermission=" + rolePermission +
        ", description=" + description +
        ", ctime=" + ctime +
        ", mtime=" + mtime +
        ", deleted=" + deleted +
        "}";
    }
}
