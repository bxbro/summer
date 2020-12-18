package com.bxbro.summer.common.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 *   菜单表
 * </p>
 *
 * @author auto-generator
 * @since 2020-12-18
 */
@TableName("t_menu")
public class Menu extends Model<Menu> {

    private static final long serialVersionUID=1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 菜单路径
     */
    private String menuUrl;

    /**
     * 菜单等级
     */
    private Boolean menuLevel;

    /**
     * 菜单的排序编号
     */
    private Boolean sortNo;

    /**
     * 菜单是否启用
     */
    private Boolean enabled;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public Boolean getMenuLevel() {
        return menuLevel;
    }

    public void setMenuLevel(Boolean menuLevel) {
        this.menuLevel = menuLevel;
    }

    public Boolean getSortNo() {
        return sortNo;
    }

    public void setSortNo(Boolean sortNo) {
        this.sortNo = sortNo;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public static final String ID = "id";

    public static final String MENU_NAME = "menu_name";

    public static final String MENU_URL = "menu_url";

    public static final String MENU_LEVEL = "menu_level";

    public static final String SORT_NO = "sort_no";

    public static final String ENABLED = "enabled";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Menu{" +
        "id=" + id +
        ", menuName=" + menuName +
        ", menuUrl=" + menuUrl +
        ", menuLevel=" + menuLevel +
        ", sortNo=" + sortNo +
        ", enabled=" + enabled +
        "}";
    }
}
