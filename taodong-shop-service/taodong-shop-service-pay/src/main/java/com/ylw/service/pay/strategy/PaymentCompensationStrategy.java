package com.ylw.service.pay.strategy;

import com.ylw.service.pay.mapper.entity.PaymentChannelEntity;
import com.ylw.service.pay.mapper.entity.PaymentTransactionEntity;

public interface PaymentCompensationStrategy {
    /**
     * 渠道名称
     *
     * @return
     */
    public Boolean payMentCompensation(PaymentTransactionEntity paymentTransaction, PaymentChannelEntity paymentChanne);
}