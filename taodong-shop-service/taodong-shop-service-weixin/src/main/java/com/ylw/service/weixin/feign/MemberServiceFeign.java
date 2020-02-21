package com.ylw.service.weixin.feign;

import com.ylw.service.api.member.MemberService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("taodong-shop-service-member")
public interface MemberServiceFeign extends MemberService {

}
