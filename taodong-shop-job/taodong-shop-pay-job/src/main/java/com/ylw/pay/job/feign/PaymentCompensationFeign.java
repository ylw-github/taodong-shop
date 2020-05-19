package com.ylw.pay.job.feign;

import com.ylw.service.api.pay.PaymentCompensationService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("taodong-shop-service-pay")
public interface PaymentCompensationFeign extends PaymentCompensationService {
}
