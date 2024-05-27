package org.mild.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.mild.common.constant.CommonConstant;
import org.mild.common.domain.Result;
import org.mild.common.exception.errorEnums.ErrorEnum;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author 史偕成
 * @title LocaleConfigBaseVO
 * @description
 * @create 2023/11/28 9:23
 */
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 运行时异常处理
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public Result<?> runtimeExceptionHandler(Exception exception) {
        log.error(exception.getMessage(), exception);
        return Result.failure(CommonConstant.DEFAULT_ERROR, CommonConstant.SYSTEM_ERROR);
    }

    /**
     * 通用业务异常
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(value = ServiceException.class)
    public Result<?> ServiceExceptionHandler(ServiceException exception) {
        ErrorEnum errorEnum = exception.getErrorEnum();
        log.error(errorEnum.getMsg(), exception);
        return Result.failure(errorEnum.getCode(), errorEnum.getMsg());
    }

    /**
     * 基础业务异常
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(value = BaseException.class)
    public Result<?> baseExceptionHandler(BaseException exception) {
        ErrorEnum errorEnum = exception.getErrorEnum();
        log.error(errorEnum.getMsg(), exception);
        return Result.failure(errorEnum.getCode(), errorEnum.getMsg());
    }

}
