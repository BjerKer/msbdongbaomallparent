package com.msb.dongbao.portal.web.advice;

import com.msb.dongbao.common.base.result.ResultWrapper;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.security.auth.login.LoginException;

/**
 * @author: Yunpeng Li
 * @date: 2021/7/11 7:17 下午
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ArithmeticException.class)
    public ResultWrapper allException(){
        return ResultWrapper.builder().code(301).msg("统一异常").build();
    }

    @ExceptionHandler(LoginException.class)
    public ResultWrapper loginException(Exception e) {
        return ResultWrapper.getFailBuilder().code(501).msg(e.getMessage()).build();
    }
}
