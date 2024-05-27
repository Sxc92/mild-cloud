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
@EqualsAndHashCode(callSuper = true)
@Data
@TableName
public class Account extends BaseModifyEntity {

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


    private Integer type;
}
