package com.msb.dongbao.portal.web.controller.captchaStudy;

import com.msb.dongbao.common.base.annotations.TokenCheck;
import com.ramostear.captcha.HappyCaptcha;
import com.wf.captcha.ArithmeticCaptcha;
import com.wf.captcha.SpecCaptcha;
import com.wf.captcha.utils.CaptchaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
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
//            CaptchaUtil.out(request,response);

            //math
            ArithmeticCaptcha arithmeticCaptcha = new ArithmeticCaptcha(200 ,50);
            arithmeticCaptcha.setLen(3);

            CaptchaUtil.out(arithmeticCaptcha,request,response);

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
    public Map<String, String> generatorRedis(HttpServletRequest request, HttpServletResponse response){

        SpecCaptcha specCaptcha = new SpecCaptcha(100, 50);
        String text = specCaptcha.text();
        System.out.println("验证码" + text);

        String uuid = UUID.randomUUID().toString();
        stringRedisTemplate.opsForValue().set(uuid,text);

        String s1 = specCaptcha.toBase64();


        Map<String,String> map = new HashMap<>();
        map.put("uuid",uuid);
        map.put("base64",s1);

        return map;

    }

    @GetMapping("/verify-redis")
    @TokenCheck(required = false)
    public String verifyRedis(String verifyCode, @RequestBody Map<String,String> map) {
        String uuid = map.get("uuid");
        String c = stringRedisTemplate.opsForValue().get(uuid);
        System.out.println(uuid);
        if (verifyCode.equals(c)) {
            return "校验通过";
        }
        return "校验不通过";
    }

}
