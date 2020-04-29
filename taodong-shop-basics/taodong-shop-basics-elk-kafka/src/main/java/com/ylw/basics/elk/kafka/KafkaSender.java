package com.ylw.basics.elk.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.alibaba.fastjson.JSON;

import lombok.extern.slf4j.Slf4j;


/**
 * description: kafka发送工具类
 * create by: YangLinWei
 * create time: 2020/4/29 4:05 下午
 */
@Component
@Slf4j
public class KafkaSender<T> {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    /**
     * kafka 发送消息
     *
     * @param obj 消息对象
     */
    public void send(T obj) {
        String jsonObj = JSON.toJSONString(obj);
        log.info("send message = {}", jsonObj);

        // 发送消息
        ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send("product_log", jsonObj);
        future.addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
            @Override
            public void onFailure(Throwable throwable) {
                log.info("The message failed to be sent:" + throwable.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, Object> stringObjectSendResult) {
                // TODO 业务处理
                log.info("The message was sent successfully: " + stringObjectSendResult.toString());
            }
        });
    }
}