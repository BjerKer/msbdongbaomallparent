package com.msb.dongbao.portal.web.controller.captchaStudy;

import com.msb.dongbao.common.base.annotations.TokenCheck;
import com.msb.dongbao.portal.web.code.ImageCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Base64;

/**
 * @author: Yunpeng Li
 * @date: 2021/7/14 11:34 上午
 */
@RestController
@RequestMapping("/code")
public class VerifyCodeController {
    String attrName = "verifycode";

    @GetMapping("/generator")
    @TokenCheck(required = false)
    public void generator(HttpServletRequest request, HttpServletResponse response){
        try{
            ImageCode imageCode = ImageCode.getInstance();
            //验证码的值
            String code = imageCode.getCode();
            request.getSession().setAttribute(attrName,code);
            System.out.println(code);
            //image
            ByteArrayInputStream image = imageCode.getImage();

            response.setContentType("image/jpeg");

            byte[] bytes = new byte[1024];
            try(ServletOutputStream out = response.getOutputStream()) {
                while (image.read(bytes) != -1) {
                    out.write(bytes);
                }
            } catch (Exception e) {
                System.out.println("异常");
            }

        }catch (Exception e) {
            System.out.println("异常");
        }
    }


    @GetMapping("verify")
    @TokenCheck(required = false)
    public String verify(String verifyCode, HttpServletRequest request) {
        String s = request.getSession().getAttribute(attrName).toString();
        System.out.println(s);
        System.out.println(verifyCode);
        System.out.println(verifyCode.equals(s));
        if (verifyCode.equals(s)) {
           return "验证码校验成功";
        }
        return "验证码校验不成功";
    }


    @GetMapping("/generatorCodeBase64")
    @TokenCheck(required = false)
    public String generatorCodeBase64(HttpServletRequest request, HttpServletResponse response){
        try{
            ImageCode imageCode = ImageCode.getInstance();
            //验证码的值
            String code = imageCode.getCode();
            request.getSession().setAttribute(attrName,code);

            ByteArrayInputStream image = imageCode.getImage();

            request.getSession().setAttribute(attrName,code);

            ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
            byte[] buff = new byte[1024];
            int r = 0;
            while ((r = image.read(buff,0,1024)) > 0) {
                swapStream.write(buff,0,r);
            }

            byte[] data = swapStream.toByteArray();

            return Base64.getEncoder().encodeToString(data);


        }catch (Exception e) {
            System.out.println("异常");

            return "";
        }
    }




}
