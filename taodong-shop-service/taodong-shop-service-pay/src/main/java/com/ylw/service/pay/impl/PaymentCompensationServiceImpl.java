package com.ylw.service.pay.impl;

import com.alibaba.fastjson.JSONObject;
import com.ylw.common.web.core.api.BaseApiService;
import com.ylw.common.web.core.entity.BaseResponse;
import com.ylw.service.api.pay.PaymentCompensationService;
import com.ylw.service.pay.factory.CompensationStrategyFactory;
import com.ylw.service.pay.mapper.PaymentChannelMapper;
import com.ylw.service.pay.mapper.PaymentTransactionMapper;
import com.ylw.service.pay.mapper.entity.PaymentChannelEntity;
import com.ylw.service.pay.mapper.entity.PaymentTransactionEntity;
import com.ylw.service.pay.strategy.PaymentCompensationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PaymentCompensationServiceImpl extends BaseApiService<JSONObject> implements PaymentCompensationService {
    @Autowired
    private PaymentTransactionMapper paymentTransactionMapper;
    @Autowired
    private PaymentChannelMapper paymentChannelMapper;

    @Override
    public BaseResponse<JSONObject> payMentCompensation(String payMentId) {
        if (StringUtils.isEmpty(payMentId)) {
            return setResultError("payMentId不能为空");
        }
        PaymentTransactionEntity paymentTransaction = paymentTransactionMapper.selectByPaymentId(payMentId);
        if (paymentTransaction == null) {
            return setResultError("paymentTransaction为空!");
        }

        // 2.获取所有的渠道重试id
        List<PaymentChannelEntity> paymentChannelList = paymentChannelMapper.selectAll();
        for (PaymentChannelEntity pcl : paymentChannelList) {
            if (pcl != null) {
                return compensationStrategy(paymentTransaction, pcl);
            }
        }

        return setResultError("没有执行重试任务");
    }

    private BaseResponse<JSONObject> compensationStrategy(PaymentTransactionEntity paymentTransaction,
                                                          PaymentChannelEntity paymentChannelEntity) {
        String retryBeanId = paymentChannelEntity.getRetryBeanId();
        PaymentCompensationStrategy paymentCompensationStrategy = CompensationStrategyFactory
                .getPaymentCompensationStrategy(retryBeanId);
        // 3.实现子类重试
        Boolean payMentCompensation = paymentCompensationStrategy.payMentCompensation(paymentTransaction,
                paymentChannelEntity);
        return payMentCompensation ? setResultSuccess("重试成功!") : setResultError("重试失败!");
    }

}
