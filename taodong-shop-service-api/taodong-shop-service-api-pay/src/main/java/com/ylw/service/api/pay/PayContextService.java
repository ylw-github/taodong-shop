package com.ylw.service.api.pay;

import com.alibaba.fastjson.JSONObject;
import com.ylw.common.web.core.entity.BaseResponse;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * description: 根据不同的渠道id(支付方式) 返回不同的支付提交表单
 * create by: YangLinWei
 * create time: 2020/5/13 4:43 下午
 */
public interface PayContextService {
    @GetMapping("/toPayHtml")
    public BaseResponse<JSONObject> toPayHtml(String channelId, String payToken);

}
