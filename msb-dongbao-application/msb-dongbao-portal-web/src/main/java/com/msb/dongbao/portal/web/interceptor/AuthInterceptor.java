package com.msb.dongbao.portal.web.interceptor;

import com.msb.dongbao.common.base.TokenException;
import com.msb.dongbao.common.base.annotations.TokenCheck;
import com.msb.dongbao.common.util.JwtUtil;
import com.sun.xml.internal.ws.handler.HandlerException;
import io.netty.util.internal.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author: Yunpeng Li
 * @date: 2021/7/12 9:17 上午
 */
public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("拦截器进入");
        String token = request.getHeader("token");
        if (StringUtils.isBlank(token)) {
            throw new TokenException("token 为空");
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        if (method.isAnnotationPresent(TokenCheck.class)) {
            TokenCheck annotation = method.getAnnotation(TokenCheck.class);
            if (annotation.required()) {
                try{
                    JwtUtil.parseToken(token);
                    return true;
                } catch (Exception e){
                    throw new TokenException("token 异常");
                }
            }
        }
        return true;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
