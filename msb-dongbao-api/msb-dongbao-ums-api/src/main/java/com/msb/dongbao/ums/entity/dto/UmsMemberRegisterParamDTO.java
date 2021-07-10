package com.msb.dongbao.ums.entity.dto;

import lombok.Data;
import lombok.ToString;

/**
 * @author: Yunpeng Li
 * @date: 2021/7/10 1:41 下午
 */
@Data
@ToString
public class UmsMemberRegisterParamDTO {

    private String username;
    private String password;
    private String icon;
    private String email;
    private String nickname;


}
