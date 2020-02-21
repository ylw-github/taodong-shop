package com.ylw.common.core.entity;

import lombok.Data;

/**
 * description: 微服务接口封装,T为返回接口data的数据类型
 * create by: YangLinWei
 * create time: 2020/2/20 11:49 上午
 */
@Data
public class BaseResponse<T> {

    private Integer rtnCode;
    private String msg;
    private T data;

    public BaseResponse() {

    }

    public BaseResponse(Integer rtnCode, String msg, T data) {
        super();
        this.rtnCode = rtnCode;
        this.msg = msg;
        this.data = data;
    }

}
