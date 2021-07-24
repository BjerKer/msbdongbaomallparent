package com.msb.dongbao.portal.web.controller.captchaStudy;

import com.msb.dongbao.common.base.annotations.TokenCheck;
import com.ramostear.captcha.HappyCaptcha;
import com.ramostear.captcha.support.CaptchaStyle;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: Yunpeng Li
 * @date: 2021/7/15 10:27 下午
 */
@RestController
@RequestMapping("/happy-captcha")
public class HappyCaptchaController {
    @GetMapping("/generator")
    @TokenCheck(required = false)
    public void generator(HttpServletRequest request, HttpServletResponse response){
        HappyCaptcha.require(request,response).style(CaptchaStyle.ANIM).build().finish();
    }


    @GetMapping("/verify")
    @TokenCheck(required = false)
    public String verify(String verifyCode, HttpServletRequest request) {
        Boolean aBoolean = HappyCaptcha.verification(request,verifyCode,true);
        if (aBoolean) {
            return "校验通过";
        }
        return "校验不通过";
    }
}
