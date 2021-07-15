package com.msb.dongbao.common.base.result;

import com.msb.dongbao.common.base.enums.StateCodeEnum;
import lombok.Builder;
import lombok.Data;
import java.io.Serializable;
import lombok.extern.slf4j.Slf4j;


/**
 * @author: Yunpeng Li
 * @date: 2021/7/11 2:44 下午
 */
@Data
@Builder
public class ResultWrapper<T> implements Serializable {
    //状态码
    private int code;

    //提示信息
    private String msg;

    private T date;

    //返回成功的包装

    public static ResultWrapper.ResultWrapperBuilder getSuccessBuilder(){
        return ResultWrapper.builder()
                .code(StateCodeEnum.SUCCESS.getCode())
                .msg(StateCodeEnum.SUCCESS.getMsg());
    }

    public static ResultWrapper.ResultWrapperBuilder getFailBuilder(){
        return ResultWrapper.builder()
                .code(StateCodeEnum.FAIL.getCode())
                .msg(StateCodeEnum.FAIL.getMsg());
    }



}
