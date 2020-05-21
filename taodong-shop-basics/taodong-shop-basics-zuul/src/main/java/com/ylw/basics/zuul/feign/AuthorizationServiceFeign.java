package com.ylw.basics.zuul.feign;


import com.ylw.service.api.auth.AuthorizationService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("taodong-shop-service-auth")
public interface AuthorizationServiceFeign extends AuthorizationService {

}
