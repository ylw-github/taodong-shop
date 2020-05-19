package com.ylw.service.pay.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class RabbitmqConfig {

    // 添加积分队列
    public static final String INTEGRAL_DIC_QUEUE = "integral_queue";
    // 补单队列，
    public static final String INTEGRAL_CREATE_QUEUE = "integral_create_queue";
    // 积分交换机
    private static final String INTEGRAL_EXCHANGE_NAME = "integral_exchange_name";

    // 1.定义订单队列
    @Bean
    public Queue directIntegralDicQueue() {
        return new Queue(INTEGRAL_DIC_QUEUE);
    }

    // 2.定义补订单队列
    @Bean
    public Queue directCreateintegralQueue() {
        return new Queue(INTEGRAL_CREATE_QUEUE);
    }

    // 2.定义交换机
    @Bean
    DirectExchange directintegralExchange() {
        return new DirectExchange(INTEGRAL_EXCHANGE_NAME);
    }

    // 3.积分队列与交换机绑定
    @Bean
    Binding bindingExchangeintegralDicQueue() {
        return BindingBuilder.bind(directIntegralDicQueue()).to(directintegralExchange()).with("integralRoutingKey");
    }

    // 3.补单队列与交换机绑定
    @Bean
    Binding bindingExchangeCreateintegral() {
        return BindingBuilder.bind(directCreateintegralQueue()).to(directintegralExchange()).with("integralRoutingKey");
    }

}