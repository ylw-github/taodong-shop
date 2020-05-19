package com.ylw.service.pay.consumer;

import com.alibaba.fastjson.JSONObject;
import com.rabbitmq.client.Channel;
import com.ylw.service.pay.constant.PayConstant;
import com.ylw.service.pay.mapper.PaymentTransactionMapper;
import com.ylw.service.pay.mapper.entity.PaymentTransactionEntity;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * description: 支付回调检查状态，是否为已经支付完成
 * create by: YangLinWei
 * create time: 2020/5/19 1:52 下午
 */
@Component
@Slf4j
public class PayCheckStateConsumer {
    @Autowired
    private PaymentTransactionMapper paymentTransactionMapper;

    // 死信队列（备胎） 消息被拒绝、队列长度满了 定时任务 人工补偿

    @RabbitListener(queues = "integral_create_queue")
    public void process(Message message, @Headers Map<String, Object> headers, Channel channel) throws IOException {
        try {
            String messageId = message.getMessageProperties().getMessageId();
            String msg = new String(message.getBody(), "UTF-8");
            log.info(">>>messageId:{},msg:{}", messageId, msg);
            JSONObject jsonObject = JSONObject.parseObject(msg);
            String paymentId = jsonObject.getString("paymentId");
            if (StringUtils.isEmpty(paymentId)) {
                log.error(">>>>支付id不能为空 paymentId:{}", paymentId);
                basicNack(message, channel);
                return;
            }
            // 1.使用paymentId查询之前是否已经支付过
            PaymentTransactionEntity paymentTransactionEntity = paymentTransactionMapper.selectByPaymentId(paymentId);
            if (paymentTransactionEntity == null) {
                log.error(">>>>支付id paymentId:{} 未查询到", paymentId);
                basicNack(message, channel);
                return;
            }
            Integer paymentStatus = paymentTransactionEntity.getPaymentStatus();
            if (paymentStatus.equals(PayConstant.PAY_STATUS_SUCCESS)) {
                log.error(">>>>支付id paymentId:{} ", paymentId);
                basicNack(message, channel);
                return;
            }
            // 安全期间 主动调用第三方接口查询
            String paymentChannel = jsonObject.getString("paymentChannel");
            int updatePaymentStatus = paymentTransactionMapper.updatePaymentStatus(PayConstant.PAY_STATUS_SUCCESS + "",
                    paymentId, paymentChannel);
            if (updatePaymentStatus > 0) {
                basicNack(message, channel);
                return;
            }
            // 继续重试

        } catch (Exception e) {
            e.printStackTrace();
            basicNack(message, channel);
        }

    }

    private void basicNack(Message message, Channel channel) throws IOException {
        channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);

    }

}
