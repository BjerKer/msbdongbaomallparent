package com.msb.dongbao.ums;

import com.msb.dongbao.ums.entity.dto.UmsMemberRegisterParamDTO;
import com.msb.dongbao.ums.service.UmsMemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author: Yunpeng Li
 * @date: 2021/7/11 12:40 下午
 */
@SpringBootTest(classes = MsbDongbaoUmsApplication.class)
public class UmsTest {
    @Autowired
    UmsMemberService umsMemberService;

    @Autowired
    UmsMemberRegisterParamDTO umsMemberRegisterParamDTO;

    @Test
    public void registerTest(){
        umsMemberRegisterParamDTO.setUsername("cc");
        umsMemberRegisterParamDTO.setPassword("123");
        umsMemberRegisterParamDTO.setEmail("l@123.com");
        umsMemberRegisterParamDTO.setNickname("c");
        umsMemberService.register(umsMemberRegisterParamDTO);
    }

}
