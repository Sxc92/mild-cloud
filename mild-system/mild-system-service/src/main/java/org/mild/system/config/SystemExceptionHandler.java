package org.mild.system.config;

import lombok.extern.slf4j.Slf4j;
import org.mild.common.exception.GlobalExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常捕获
 *
 * @author 史偕成
 * @date 2024/05/26 22:42
 **/
@Slf4j
@RestControllerAdvice
public class SystemExceptionHandler extends GlobalExceptionHandler {

}
