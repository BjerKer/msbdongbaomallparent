package com.msb.dongbao.ums.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author: Yunpeng Li
 * @date: 2021/7/9 4:52 下午
 */
@Component
public class MyHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        System.out.println("添加插入时间");
        this.setFieldValByName("gmtCreate",new Date(),metaObject);
        this.setFieldValByName("gmtModified",new Date(),metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        System.out.println("更新时间");
        this.setFieldValByName("gmtModified",new Date(),metaObject);

    }
}
