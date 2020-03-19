package com.ylw.portal.pay.web.controller;

import com.ylw.common.web.core.base.BaseWebController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * description: 首页
 * create by: YangLinWei
 * create time: 2020/3/19 1:40 下午
 */
@Controller
public class IndexController extends BaseWebController {

    /**
     * 跳转到index页面
     */
    private static final String INDEX_FTL = "index";

    @RequestMapping("/")
    public String index(HttpServletRequest request, HttpServletResponse response, Model model) {
        return INDEX_FTL;
    }
}
