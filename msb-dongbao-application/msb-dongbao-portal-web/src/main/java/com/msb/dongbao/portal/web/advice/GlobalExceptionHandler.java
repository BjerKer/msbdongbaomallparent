package com.msb.dongbao.portal.web.advice;

import com.baomidou.kaptcha.Kaptcha;
import com.baomidou.kaptcha.exception.KaptchaException;
import com.baomidou.kaptcha.exception.KaptchaIncorrectException;
import com.baomidou.kaptcha.exception.KaptchaNotFoundException;
import com.baomidou.kaptcha.exception.KaptchaTimeoutException;
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

    @ExceptionHandler(KaptchaException.class)
    public String kcaptchaException(KaptchaException e){
        if(e instanceof KaptchaTimeoutException) {
            return "超时";
        } else if (e instanceof KaptchaNotFoundException) {
            return "没找到";
        } else if (e instanceof KaptchaIncorrectException) {
            return "不正确";
        } else {
            return "其他错误";
        }

    }

}
