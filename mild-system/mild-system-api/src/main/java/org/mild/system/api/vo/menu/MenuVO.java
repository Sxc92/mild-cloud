package org.mild.system.api.vo.menu;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.mild.common.web.vo.BaseVO;
import org.mild.system.api.constant.MenuEnums;

/**
 * @author 史偕成
 * @title LocaleConfigBaseVO
 * @description
 * @create 2023/11/28 9:23
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class MenuVO extends BaseVO {

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 父Id
     */
    private String parentId;

    /**
     * icon 图标
     */
    private String icon;

    /**
     * 组件
     */
    private String component;

    /**
     * 菜单地址（前端路径）
     */
    private String path;

    /**
     * 菜单类型 {@link MenuEnums.MenuType}0: 目录、1:菜单、2:按钮
     */
    private Integer type;

    /**
     * 权限标识 例如 M:sys:menu:add (新增按钮) M:SYS:MENU:VIEW (查询按钮)
     */
    private String permission;

    /**
     * 菜单排序
     */
    private Integer sorted;


    /**
     * {@link MenuEnums.MenuVisible}
     */
    private boolean visible;
}
