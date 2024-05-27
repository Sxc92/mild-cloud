package org.mild.common.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

import static org.mild.common.constant.CommonConstant.*;

/**
 * 统一返回类
 *
 * @author 史偕成
 * @date 2024/05/19 21:19
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;


    /**
     * 数据
     */
    private T data;


    /**
     * 状态码
     */
    private int code;

    /**
     * 消息
     */
    private String msg;


    /**
     * 创建一个表示操作成功的结果对象Result<T>的工厂方法。
     *
     * @param code 状态码，通常表示操作的HTTP状态码或自定义状态码
     * @param msg  描述操作结果的消息
     * @return Result<T>对象，表示操作成功
     */
    public static <T> Result<T> success(int code, String msg) {
        return new Result<>(null, code, msg);
    }

    /**
     * 创建一个表示操作成功的结果对象Result<T>的工厂方法。
     *
     * @param data 操作成功时返回的数据
     * @return Result<T>对象，表示操作成功
     */
    public static <T> Result<T> success(T data) {
        return new Result<>(data, DEFAULT_SUCCESS, DEFAULT_SUCCESS_MSG);
    }

    /**
     * 创建一个表示操作成功的结果对象Result<T>的工厂方法。
     *
     * @param data 操作成功时返回的数据
     * @param code 状态码，通常表示操作的HTTP状态码或自定义状态码
     * @param msg  描述操作结果的消息
     * @return Result<T>对象，表示操作成功
     */
    public static <T> Result<T> success(T data, int code, String msg) {
        return new Result<T>(data, code, msg);
    }

    /**
     * 创建一个表示操作成功的结果对象Result<T>的工厂方法。
     *
     * @param data 操作成功时返回的数据
     * @return Result<T>对象，表示操作成功
     */
    public static <T> Result<T> success(T data, int code) {
        return new Result<>(data, code, DEFAULT_SUCCESS_MSG);
    }


    /**
     * 创建一个表示失败的结果对象。
     *
     * @param code 错误代码，用于标识错误的类型。
     * @param msg  错误信息，用于描述错误的详细信息。
     * @param <T>  结果对象的类型。
     * @return 返回一个包含错误代码和错误信息的Result对象，数据字段为null。
     */
    public static <T> Result<T> failure(int code, String msg) {
        return new Result<>(null, code, msg);
    }

    /**
     * 创建一个表示失败的结果对象。
     *
     * @param <T> 结果对象的类型。
     * @return 返回一个包含默认错误代码和错误消息的 Result 对象，其数据部分为 null。
     */
    public static <T> Result<T> failure() {
        return new Result<>(null, DEFAULT_ERROR, DEFAULT_ERROR_MSG);
    }
}
