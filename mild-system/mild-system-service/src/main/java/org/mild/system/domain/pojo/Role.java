package org.mild.system.domain.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.mild.common.mybatis.base.BaseModifyEntity;
import org.mild.system.api.constant.RoleEnums;

/**
 * @author 史偕成
 * @date 2024/06/01 13:02
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("mild_sys_role")
public class Role extends BaseModifyEntity {

    /**
     * 角色名称
     */
    private String name;

    /**
     * 状态 {@link RoleEnums.RoleStatus}
     */
    private Integer status;

    /**
     * 是否管理员角色
     */
    private Boolean adminFlag;
}
