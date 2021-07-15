package com.msb.dongbao.common.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author: Yunpeng Li
 * @date: 2021/7/11 9:26 下午
 */
public class JwtUtil {
    private static final String secret = "asdfasdf";

    public static String createToken(String subject){

        String token = Jwts.builder().setSubject(subject)
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 100))
                .signWith(SignatureAlgorithm.HS256,secret)
                .compact();
        return token;
    }
    public static String parseToken(String token) {
        Claims body = Jwts.parser().setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();

        String subject = body.getSubject();
        return subject;
    }

    public static void main(String[] args) {
        String name = "yunpeng";
        String token = createToken(name);
        System.out.println("token:  " + token);

        String s = parseToken(token);
        System.out.println("parse: " + s);


        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        s = parseToken(token);
        System.out.println("parse: " + s);

    }
}
