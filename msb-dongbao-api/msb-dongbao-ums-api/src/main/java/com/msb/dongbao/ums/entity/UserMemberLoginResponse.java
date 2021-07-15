package com.msb.dongbao.ums.entity;

import lombok.Data;

/**
 * @author: Yunpeng Li
 * @date: 2021/7/12 8:19 上午
 */
@Data
public class UserMemberLoginResponse {
    private String token;
    private UmsMember umsMember;
}
