package org.mild.system.api.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.mild.common.domain.vo.BaseVO;
import org.mild.system.api.constant.AccountEnums;

/**
 * @author 史偕成
 * @title LocaleConfigBaseVO
 * @description
 * @create 2023/11/28 9:23
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserVO extends BaseVO {
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


}
