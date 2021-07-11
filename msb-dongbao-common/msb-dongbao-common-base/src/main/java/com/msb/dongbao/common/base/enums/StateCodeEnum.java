package com.msb.dongbao.common.base.enums;


/**
 * @author: Yunpeng Li
 * @date: 2021/7/11 2:40 下午
 *
 * 100-199 用户业务
 * 200-299 支付业务
 */
public enum StateCodeEnum {
    //password empty
    USER_EMPTY(1002,"密码为空"),
    //password error
    PASSWORD_ERROR(1001,"密码错误"),

    //success
    SUCCESS(200,"请求成功"),
    //
    FAIL(500,"请求失败");


    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    StateCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
