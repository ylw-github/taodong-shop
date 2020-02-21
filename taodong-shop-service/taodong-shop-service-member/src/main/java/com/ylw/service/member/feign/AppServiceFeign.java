package com.ylw.service.member.feign;


import com.ylw.service.api.weixin.AppService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "taodong-shop-service-weixin")
public interface AppServiceFeign extends AppService {

}
