package org.mild.common.exception.errorEnums;

/**
 * @author 史偕成
 * @date 2024/05/20 21:42
 **/
public interface ErrorEnum {
    /**
     * 获取错误码
     *
     * @return
     */
    int getCode();

    /**
     * 获取错误信息
     *
     * @return
     */
    String getMsg();
}
