package com.ylw.common.web.core.entity;

import lombok.Data;

/**
 * description: 微服务接口封装,T为返回接口data的数据类型
 * create by: YangLinWei
 * create time: 2020/2/20 11:49 上午
 */
@Data
public class BaseResponse<T> {

    /**
     * 返回码
     */
    private Integer code;
    /**
     * 消息
     */
    private String msg;
    /**
     * 返回
     */
    private T data;
    // 分页

    public BaseResponse() {

    }

    public BaseResponse(Integer code, String msg, T data) {
        super();
        this.code = code;
        this.msg = msg;
        this.data = data;
    }


}
