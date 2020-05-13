package com.ylw.feign;

import com.ylw.service.api.pay.PaymentChannelService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("taodong-shop-service-pay")
public interface PaymentChannelFeign extends PaymentChannelService {

}
