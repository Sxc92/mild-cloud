package org.mild.system.domain.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.mild.common.mybatis.base.BaseModifyEntity;

/**
 * @author 史偕成
 * @date 2024/06/03 07:55
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("mild_sys_menu")
public class Menu extends BaseModifyEntity {

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
     * 菜单类型 0: 目录、1:菜单、2:按钮
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
     * 是否可见，0显示，1隐藏
     */
    private boolean visible;
}
