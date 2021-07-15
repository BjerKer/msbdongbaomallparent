package com.msb.dongbao.portal.web.controller;

import com.msb.dongbao.common.base.annotations.TokenCheck;
import com.ramostear.captcha.HappyCaptcha;
import com.ramostear.captcha.support.CaptchaStyle;
import com.wf.captcha.SpecCaptcha;
import com.wf.captcha.utils.CaptchaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

/**
 * @author: Yunpeng Li
 * @date: 2021/7/15 10:27 下午
 */
@RestController
@RequestMapping("/easy-captcha")
public class EasyCaptchaController {
    @GetMapping("/generator")
    @TokenCheck(required = false)
    public void generator(HttpServletRequest request, HttpServletResponse response){
        try {
            CaptchaUtil.out(request,response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @GetMapping("/verify")
    @TokenCheck(required = false)
    public String verify(String verifyCode, HttpServletRequest request) {
        Boolean aBoolean = CaptchaUtil.ver(verifyCode,request);
        if (aBoolean) {
            return "校验通过";
        }
        return "校验不通过";
    }
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/generator-redis")
    @TokenCheck(required = false)
    public void generatorRedis(HttpServletRequest request, HttpServletResponse response){
        try {
            SpecCaptcha specCaptcha = new SpecCaptcha(100, 50);
            String text = specCaptcha.text();
            System.out.println("验证码" + text);

            String s = request.getSession().getId();
            stringRedisTemplate.opsForValue().set(s,text);



            CaptchaUtil.out(specCaptcha,request,response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/verify-redis")
    @TokenCheck(required = false)
    public String verifyRedis(String verifyCode, HttpServletRequest request) {
        String s = request.getSession().getId();
        String c = stringRedisTemplate.opsForValue().get(s);
        if (verifyCode.equals(c)) {
            return "校验通过";
        }
        return "校验不通过";
    }

}
