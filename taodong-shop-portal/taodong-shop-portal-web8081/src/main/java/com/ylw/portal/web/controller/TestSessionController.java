package com.ylw.portal.web.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class TestSessionController {

    @Value("${server.port}")
    private Integer projectPort;// 项目端口

    @RequestMapping("/createSession")
    public String createSession(HttpSession session, String name) {
        session.setAttribute("name", name);
        return "当前项目端口->" + projectPort + " sessionId->" + session.getId() + "在Session中存入成功！";
    }

    @RequestMapping("/getSession")
    public String getSession(HttpSession session) {
        return "当前项目端口->" + projectPort + " sessionId->" + session.getId() + " 姓名->" + session.getAttribute("name");
    }
}
