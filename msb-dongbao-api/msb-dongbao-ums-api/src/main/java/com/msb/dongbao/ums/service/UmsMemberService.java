package com.msb.dongbao.ums.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.msb.dongbao.ums.entity.UmsMember;

/**
 * <p>
 * 后台用户表 服务类
 * </p>
 *
 * @author yunpengli
 * @since 2021-07-09
 */
public interface UmsMemberService extends IService<UmsMember> {
    public String register();
}
