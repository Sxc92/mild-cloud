package org.mild.system.api.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.mild.common.exception.errorEnums.ErrorEnum;

/**
 * @author 史偕成
 * @date 2024/05/26 22:37
 **/
@Getter
@AllArgsConstructor
public enum ExceptionEnums implements ErrorEnum {
    /**
     * 账户相关
     */
    ACCOUNT_NOT_FOUND(10001, "账号不存在"),
    ACCOUNT_PASSWORD_ERROR(10002, "账号密码错误"),
    ACCOUNT_NOT_ENABLE(10003, "账号未启用"),
    ACCOUNT_NOT_LOGIN(10004, "账号未登录"),
    ACCOUNT_NOT_LOGIN_OUT(10005, "账号未登出"),
    ACCOUNT_NOT_LOGIN_OUT_TIMEOUT(10006, "账号登出超时"),

    ;
    private final int code;

    private final String msg;
}
