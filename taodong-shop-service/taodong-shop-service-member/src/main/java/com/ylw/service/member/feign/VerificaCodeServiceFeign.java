package com.ylw.service.member.feign;

import com.ylw.service.api.weixin.VerificaCodeService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("taodong-shop-service-weixin")
public interface VerificaCodeServiceFeign extends VerificaCodeService {

}
