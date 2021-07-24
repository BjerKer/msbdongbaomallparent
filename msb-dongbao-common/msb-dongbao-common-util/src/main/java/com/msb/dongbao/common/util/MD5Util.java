package com.msb.dongbao.common.util;

import java.security.MessageDigest;

/**
 * @author: Yunpeng Li
 * @date: 2021/7/20 3:46 下午
 */
public class MD5Util {

    public static String md5WithSalt(String dataStr, String salt) {
        return md5(dataStr + salt);
    }
    /**
     * 获取指定字符串的md5值
     * @param dataStr 明文
     * @return String
     */
    public static String md5(String dataStr) {
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(dataStr.getBytes("UTF8"));
            byte[] s = m.digest();
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < s.length; i++) {
                result.append(Integer.toHexString((0x000000FF & s[i]) | 0xFFFFFF00).substring(6));
            }
            return result.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void main(String[] args) {
        String content1 = "原始内容";
        String s1 = md5(content1);
        System.out.println("加密后1 ： " + s1);


        String content2 = "原始内容";
        String s2 = md5(content2);
        System.out.println("加密后2 ： " + s2);

    }
}
