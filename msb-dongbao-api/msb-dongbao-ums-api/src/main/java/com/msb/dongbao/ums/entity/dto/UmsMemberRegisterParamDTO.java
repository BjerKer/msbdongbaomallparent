package com.msb.dongbao.ums.entity.dto;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * @author: Yunpeng Li
 * @date: 2021/7/10 1:41 下午
 */
@Data
@ToString
public class UmsMemberRegisterParamDTO {

    @Size(min = 1, max = 12, message = "用户名不能为空 长度1-12")
    private String username;

    @NotEmpty(message = "密码不能为空")
    private String password;

    private String icon;

    @Email
    private String email;

    private String nickname;


}
