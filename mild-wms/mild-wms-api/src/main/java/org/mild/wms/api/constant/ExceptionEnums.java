package org.mild.wms.api.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.mild.common.exception.errorEnums.ErrorEnum;

/**
 * WMS 业务异常枚举
 *
 * @author 史偕成
 * @date 2024/05/26 22:37
 **/
@Getter
@AllArgsConstructor
public enum ExceptionEnums implements ErrorEnum {
    /**
     * 账户相关
     */
    WMS(1, "");
    private final int code;

    private final String msg;
}
