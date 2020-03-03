package com.ylw.common.core.error;

import com.alibaba.fastjson.JSONObject;
import com.ylw.common.core.api.BaseApiService;
import com.ylw.common.core.entity.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * description: 全局捕获异常
 * create by: YangLinWei
 * create time: 2020/3/3 11:09 上午
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends BaseApiService<JSONObject> {
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public BaseResponse<JSONObject> exceptionHandler(Exception e) {
        log.info("###全局捕获异常###,error:{}", e);
        return setResultError("系统错误!");
    }
}