package com.ylw.taodong.service;

import com.ylw.taodong.entity.AppEntity;
import org.springframework.web.bind.annotation.GetMapping;

public interface MemberService {

    @GetMapping("/memberInvokWeixin")
    public AppEntity memberInvokWeixin();

}
