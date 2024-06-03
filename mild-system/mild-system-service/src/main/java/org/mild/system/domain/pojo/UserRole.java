package org.mild.system.domain.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.mild.common.mybatis.base.BaseEntity;

/**
 * 用户角色关联表
 *
 * @author 史偕成
 * @date 2024/06/01 13:22
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("mild_sys_user_role")
public class UserRole extends BaseEntity {

    /**
     * 账号Id
     */
    private String userId;

    /**
     * 角色Id
     */
    private String roleId;
}
