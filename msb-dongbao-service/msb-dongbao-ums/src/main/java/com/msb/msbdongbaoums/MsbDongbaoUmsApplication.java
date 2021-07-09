package com.msb.msbdongbaoums;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: Yunpeng Li
 * @date: 2021/7/9 12:14 下午
 */

@SpringBootApplication
@MapperScan("com.msb.msbdongbaoums.mapper")
public class MsbDongbaoUmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsbDongbaoUmsApplication.class);
    }

}
