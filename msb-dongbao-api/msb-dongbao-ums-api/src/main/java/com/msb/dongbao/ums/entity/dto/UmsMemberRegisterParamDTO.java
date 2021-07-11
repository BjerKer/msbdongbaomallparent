package com.msb.dongbao.ums.entity.dto;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;

/**
 * @author: Yunpeng Li
 * @date: 2021/7/10 1:41 下午
 */
@Data
@ToString
public class UmsMemberRegisterParamDTO {

    @NotEmpty(message = "用户名不能为空")
    private String username;
    @NotEmpty(message = "密码不能为空")
    private String password;
    private String icon;
    private String email;
    private String nickname;


}
