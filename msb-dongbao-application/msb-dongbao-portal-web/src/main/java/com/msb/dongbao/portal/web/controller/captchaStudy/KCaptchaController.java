package com.msb.dongbao.portal.web.controller.captchaStudy;

import com.baomidou.kaptcha.Kaptcha;
import com.baomidou.kaptcha.exception.KaptchaException;
import com.msb.dongbao.portal.web.custom.MyGoogleKaptcha;
import com.ramostear.captcha.HappyCaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: Yunpeng Li
 * @date: 2021/7/16 8:54 上午
 */
@RestController
@RequestMapping("/kcaptcha")
public class KCaptchaController {
    @Autowired
    private Kaptcha kaptcha;

    @Autowired
    MyGoogleKaptcha myGoogleKaptcha;

    @GetMapping("/generator")
    public void generatorCode () {
        kaptcha.render();
    }

    @PostMapping("/verify")
    public String verify(String verifyCode,HttpServletRequest request) {
        try{
            Boolean aBoolean = kaptcha.validate(verifyCode,10);
            if(aBoolean) {
                HappyCaptcha.remove(request);
                return "pass";
            }
        } catch (KaptchaException e) {

        }

        return "not pass";

    }
    @GetMapping("/generator-my")
    public void generatorCodeMy (HttpServletRequest request, HttpServletResponse response) {
        myGoogleKaptcha.render();
    }

    @GetMapping("/verify-my")
    public String verifyMy (String verifyCode, HttpServletRequest request){
        try{
            Boolean aBoolean = myGoogleKaptcha.validate(verifyCode,10);
            if(aBoolean) {
                return "pass";
            }
        } catch (KaptchaException e) {

        }

        return "not pass";
    }

}
