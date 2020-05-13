package com.ylw.service.pay.strategy;


import com.ylw.api.pay.dto.dto.PayMentTransacDTO;
import com.ylw.service.pay.mapper.entity.PaymentChannelEntity;

/**
 * description: 支付接口共同实现行为算法
 * create by: YangLinWei
 * create time: 2020/5/13 4:41 下午
 */
public interface PayStrategy {

    /**
     * @param pymentChannel     渠道参数
     * @param payMentTransacDTO 支付参数
     * @return
     */
    public String toPayHtml(PaymentChannelEntity pymentChannel, PayMentTransacDTO payMentTransacDTO);

}
