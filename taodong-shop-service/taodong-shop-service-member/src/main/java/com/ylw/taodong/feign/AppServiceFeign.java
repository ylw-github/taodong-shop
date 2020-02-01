package com.ylw.taodong.feign;


import com.ylw.taodong.service.AppService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "taodong-shop-service-weixin")
public interface AppServiceFeign extends AppService {

}
