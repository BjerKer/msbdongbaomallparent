package com.msb.dongbao.ums.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.msb.dongbao.common.base.result.ResultWrapper;
import com.msb.dongbao.ums.entity.UmsMember;
import com.msb.dongbao.ums.entity.dto.UmsMemberLoginParamDTO;
import com.msb.dongbao.ums.entity.dto.UmsMemberRegisterParamDTO;

/**
 * <p>
 * 后台用户表 服务类
 * </p>
 *
 * @author yunpengli
 * @since 2021-07-09
 */
public interface UmsMemberService{
    public ResultWrapper register(UmsMemberRegisterParamDTO umsMemberRegisterParamDTO);

    public ResultWrapper login(UmsMemberLoginParamDTO umsMemberLoginParamDTO);

    public ResultWrapper edit(UmsMember umsMember);
}
