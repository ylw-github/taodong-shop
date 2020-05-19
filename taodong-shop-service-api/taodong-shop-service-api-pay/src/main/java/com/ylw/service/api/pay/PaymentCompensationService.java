package com.ylw.service.api.pay;

import com.alibaba.fastjson.JSONObject;
import com.ylw.common.web.core.entity.BaseResponse;
import org.springframework.web.bind.annotation.GetMapping;

public interface PaymentCompensationService {

    /**
     * 根据payMentId查询支付信息
     *
     *
     * @param payMentId
     * @return
     */
    @GetMapping("/payMentCompensation")
    public BaseResponse<JSONObject> payMentCompensation(String payMentId);

}