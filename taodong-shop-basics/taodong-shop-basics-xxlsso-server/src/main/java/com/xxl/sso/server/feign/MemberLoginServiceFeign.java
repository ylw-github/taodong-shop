package com.xxl.sso.server.feign;

import com.ylw.service.api.member.MemberLoginService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("taodong-shop-service-member")
public interface MemberLoginServiceFeign extends MemberLoginService {

}
