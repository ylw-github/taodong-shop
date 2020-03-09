package com.ylw.member.feign;


import com.ylw.service.api.member.MemberRegisterService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("taodong-shop-service-member")
public interface MemberRegisterServiceFeign extends MemberRegisterService {

}
