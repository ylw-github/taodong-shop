package com.ylw.member.feign;

import com.ylw.service.api.member.MemberLogOutService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("taodong-shop-service-member")
public interface MemberLogoutServiceFeign extends MemberLogOutService {

}
