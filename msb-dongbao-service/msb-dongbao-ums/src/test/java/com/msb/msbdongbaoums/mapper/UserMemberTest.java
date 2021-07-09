package com.msb.msbdongbaoums.mapper;

import com.msb.msbdongbaoums.entity.UmsMember;
import com.msb.msbdongbaoums.service.UmsMemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author: Yunpeng Li
 * @date: 2021/7/9 12:01 下午
 */
@SpringBootTest(classes = com.msb.msbdongbaoums.MsbDongbaoUmsApplication.class)
public class UserMemberTest {
    @Autowired
    UmsMemberMapper umsMemberMapper;


    @Test
    void testInsert(){
        UmsMember t = new UmsMember();
        t.setUsername("yunpeng");
        t.setStatus(0);
        t.setNote("note");
        t.setNickName("pp");
        t.setEmail("1@163.com");


        umsMemberMapper.insert(t);

    }
}
