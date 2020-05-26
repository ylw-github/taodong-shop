package com.ylw.service.spike.consumer;

import com.alibaba.fastjson.JSONObject;
import com.rabbitmq.client.Channel;
import com.ylw.service.spike.mapper.OrderMapper;
import com.ylw.service.spike.mapper.SeckillMapper;
import com.ylw.service.spike.mapper.entity.OrderEntity;
import com.ylw.service.spike.mapper.entity.SeckillEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Map;

/**
 * description: 库存消费者
 * create by: YangLinWei
 * create time: 2020/5/26 10:59 上午
 */
@Component
@Slf4j
public class StockConsumer {
    @Autowired
    private SeckillMapper seckillMapper;
    @Autowired
    private OrderMapper orderMapper;

    @RabbitListener(queues = "modify_inventory_queue")
    @Transactional
    public void process(Message message, @Headers Map<String, Object> headers, Channel channel) throws IOException {
        String messageId = message.getMessageProperties().getMessageId();
        String msg = new String(message.getBody(), "UTF-8");
        log.info(">>>messageId:{},msg:{}", messageId, msg);
        JSONObject jsonObject = JSONObject.parseObject(msg);
        // 1.获取秒杀id
        Long seckillId = jsonObject.getLong("seckillId");
        SeckillEntity seckillEntity = seckillMapper.findBySeckillId(seckillId);
        if (seckillEntity == null) {
            log.warn("seckillId:{},商品信息不存在!", seckillId);
            basicNack(message, channel);
            return;
        }
        Long version = seckillEntity.getVersion();
        int inventoryDeduction = seckillMapper.optimisticDeduction(seckillId, version);
        if (!toDaoResult(inventoryDeduction)) {
            log.info(">>>seckillId:{}修改库存失败>>>>inventoryDeduction返回为{} 秒杀失败！", seckillId, inventoryDeduction);
            basicNack(message, channel);
            return;
        }
        // 2.添加秒杀订单
        OrderEntity orderEntity = new OrderEntity();
        String phone = jsonObject.getString("phone");
        orderEntity.setUserPhone(phone);
        orderEntity.setSeckillId(seckillId);
        orderEntity.setState(1l);
        int insertOrder = orderMapper.insertOrder(orderEntity);
        if (!toDaoResult(insertOrder)) {
            basicNack(message, channel);
            return;
        }
        log.info(">>>修改库存成功seckillId:{}>>>>inventoryDeduction返回为{} 秒杀成功", seckillId, inventoryDeduction);
        basicNack(message, channel);
    }

    // 调用数据库层判断
    public Boolean toDaoResult(int result) {
        return result > 0 ? true : false;
    }

    // 消费者获取到消息之后 手动签收 通知MQ删除该消息
    private void basicNack(Message message, Channel channel) throws IOException {
        channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);
    }
}
