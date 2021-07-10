package com.msb.dongbao.portal.web.md5;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.DigestUtils;

/**
 * @author: Yunpeng Li
 * @date: 2021/7/10 2:43 下午
 */
public class EncoderOrDecoderTest {

    @Test
    public void md5(){

        String sourceString = "123456";
        String s = DigestUtils.md5DigestAsHex(sourceString.getBytes());
        System.out.println("第一次加密" + s);
        s = DigestUtils.md5DigestAsHex(sourceString.getBytes());
        System.out.println("第二次加密" + s);
    }


    @Test
    public void bcrypt(){
        String sourceString = "123456";

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String s = passwordEncoder.encode(sourceString);
        System.out.println("第一次加密" + s);
        boolean matches = passwordEncoder.matches(sourceString, s);
        System.out.println("第一次验证" + matches);
        s = passwordEncoder.encode(sourceString);
        System.out.println("第二次加密" + s);
        matches = passwordEncoder.matches(sourceString, s);
        System.out.println("第2次验证" + matches);
    }

}
