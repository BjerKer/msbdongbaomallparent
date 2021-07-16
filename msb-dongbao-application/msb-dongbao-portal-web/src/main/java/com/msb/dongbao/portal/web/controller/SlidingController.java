package com.msb.dongbao.portal.web.controller;

import com.baomidou.kaptcha.exception.KaptchaException;
import com.msb.dongbao.portal.web.util.SliderUtil;
import com.msb.dongbao.portal.web.util.VerificationVO;
import javafx.scene.control.Slider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.SliderUI;

/**
 * @author: Yunpeng Li
 * @date: 2021/7/16 2:30 下午
 */
@RestController
@RequestMapping("/slider")
public class SlidingController {
    @GetMapping("/generator")
    public VerificationVO generatorCodeMy (HttpServletRequest request, HttpServletResponse response) {
        return SliderUtil.cut();
    }

    @GetMapping("/verify")
    public String verifyMy (String verifyCode, HttpServletRequest request){
//        try{
//            Boolean aBoolean = myGoogleKaptcha.validate(verifyCode,10);
//            if(aBoolean) {
//                return "pass";
//            }
//        } catch (KaptchaException e) {
//
//        }

        return "not pass";
    }

}
