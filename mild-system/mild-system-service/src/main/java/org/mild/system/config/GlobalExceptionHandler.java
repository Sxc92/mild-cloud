package org.mild.system.config;

import lombok.extern.slf4j.Slf4j;
import org.mild.common.domain.Result;
import org.mild.common.exception.ServiceException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常捕获
 *
 * @author 史偕成
 * @date 2024/05/26 22:42
 **/
@Slf4j
@RestController
public class GlobalExceptionHandler {

    /**
     * 捕获业务异常
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(value = ServiceException.class)
    public Result<?> serviceExceptionHandler(ServiceException exception) {
        return Result.failure(exception.getErrorEnum().getCode(), exception.getErrorEnum().getMsg());
    }
}
