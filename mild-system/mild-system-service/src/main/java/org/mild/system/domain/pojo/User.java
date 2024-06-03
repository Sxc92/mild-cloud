package org.mild.system.domain.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.mild.common.mybatis.base.BaseModifyEntity;
import org.mild.system.api.constant.AccountEnums;

/**
 * @author 史偕成
 * @date 2024/05/24 17:11
 **/
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mild_sys_user")
public class User extends BaseModifyEntity {

    /**
     * 账户名称
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 状态 {@link AccountEnums.AccountStatus}
     */
    private Integer status;

    /**
     * 类型 {@link AccountEnums.AccountType}
     */
    private Integer type;

    /**
     * 锁定标识 {@link AccountEnums.AccountLock}
     */
    private Integer accountLock;

    /**
     * 过期标识 {@link AccountEnums.AccountExpired}
     */
    private Integer accountExpired;

}
