package com.msb.dongbao.portal.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: Yunpeng Li
 * @date: 2021/7/9 5:42 下午
 */
@SpringBootApplication(scanBasePackages = {"com.msb"})
@MapperScan("com.msb.dongbao.ums.mapper")
public class MsbDongbaoPortalWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(MsbDongbaoPortalWebApplication.class);
    }
}
