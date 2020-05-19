package com.ylw.pay.job.handler;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import com.ylw.pay.job.feign.PaymentCompensationFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * description: 使用任务调度实现自动化补偿
 * create by: YangLinWei
 * create time: 2020/5/18 4:38 下午
 */
@JobHandler(value = "payJobHandler")
@Component
@Slf4j
public class PayJobHandler extends IJobHandler {


    @Autowired
    private PaymentCompensationFeign paymentCompensationFeign;

    @Override
    public ReturnT<String> execute(String param) throws Exception {
        log.info(">>>使用任务调度实现自动化对账");
        paymentCompensationFeign.payMentCompensation("payMentId");
        return SUCCESS;
    }

}
