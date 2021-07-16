package com.msb.dongbao.portal.web.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author: Yunpeng Li
 * @date: 2021/7/12 9:48 上午
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(authInterceptor())
//                .excludePathPatterns("/user-member/login")
//                .excludePathPatterns("/code/**")
//                .excludePathPatterns("/jcaptcha/**")
//                .excludePathPatterns("/happy-captcha/**")
//                .excludePathPatterns("/easy-captcha/**")
//                .excludePathPatterns("/kcaptcha/**")
//                .addPathPatterns("/**");
    }

    @Bean
    public AuthInterceptor authInterceptor(){
        return new AuthInterceptor();
    }
}
