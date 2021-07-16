package com.msb.dongbao.portal.web.custom;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import com.baomidou.kaptcha.Kaptcha;
import com.baomidou.kaptcha.exception.KaptchaIncorrectException;
import com.baomidou.kaptcha.exception.KaptchaNotFoundException;
import com.baomidou.kaptcha.exception.KaptchaRenderException;
import com.baomidou.kaptcha.exception.KaptchaTimeoutException;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class MyGoogleKaptcha implements Kaptcha {
    private static final Logger log = LoggerFactory.getLogger(com.baomidou.kaptcha.GoogleKaptcha.class);
    private DefaultKaptcha kaptcha;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;

    public MyGoogleKaptcha(DefaultKaptcha kaptcha) {
        this.kaptcha = kaptcha;
    }

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    public String render() {
        this.response.setDateHeader("Expires", 0L);
        this.response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        this.response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        this.response.setHeader("Pragma", "no-cache");
        this.response.setContentType("image/jpeg");
        String sessionCode = this.kaptcha.createText();

        try (ServletOutputStream out = response.getOutputStream()){

            stringRedisTemplate.opsForValue().set("ppp",sessionCode);
            ImageIO.write(this.kaptcha.createImage(sessionCode), "jpg", out);


        } catch (Exception e) {

        }
        return sessionCode;
    }

    public boolean validate(String code) {
        return this.validate(code, 900L);
    }

    public boolean validate(@NonNull String code, long second) {
        HttpSession httpSession = request.getSession(false);
        String sessionCode = stringRedisTemplate.opsForValue().get("ppp");

        if (code.equals(sessionCode)){
            stringRedisTemplate.delete("ppp");
            return true;
        }else{
            return false;
        }

    }

}


