package org.mild.common.constant;

/**
 * 数据库通用常量
 *
 * @author 史偕成
 * @date 2024/05/25 10:03
 **/
public interface CommonConstant {

    /**
     * 逻辑删除 （已删）
     */
    Integer DELETED = 1;

    /**
     * 逻辑删除 （未删）
     */
    Integer NO_DELETED = 0;


    /**
     * 默认成功状态码
     */
    int DEFAULT_SUCCESS = 200;

    /**
     * 默认成功返回消息
     */
    String DEFAULT_SUCCESS_MSG = "succeed";

    /**
     * 默认错误码
     */
    int DEFAULT_ERROR = 500;

    /**
     * 默认成功返回消息
     */
    String DEFAULT_ERROR_MSG = "failed";
}
