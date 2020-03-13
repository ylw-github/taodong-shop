package com.ylw.portal.web.controller;

import com.ylw.api.member.dto.output.UserOutDTO;
import com.ylw.common.web.core.base.BaseWebController;
import com.ylw.common.web.core.constants.WebConstants;
import com.ylw.common.web.core.entity.BaseResponse;
import com.ylw.common.web.core.util.CookieUtils;
import com.ylw.member.feign.MemberServiceFeign;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * description: 首页
 * create by: YangLinWei
 * create time: 2020/3/5 1:48 下午
 */
@Controller
public class IndexController extends BaseWebController {

    @Autowired
    private MemberServiceFeign memberServiceFeign;
    /**
     * 跳转到index页面
     */
    private static final String INDEX_FTL = "index";

    @RequestMapping("/")
    public String index(HttpServletRequest request, HttpServletResponse response, Model model) {
        // 1.从cookie 中 获取 会员token
        String token = CookieUtils.getCookieValue(request, WebConstants.LOGIN_TOKEN_COOKIENAME, true);
        if (!StringUtils.isEmpty(token)) {
            // 2.调用会员服务接口,查询会员用户信息
            BaseResponse<UserOutDTO> userInfo = memberServiceFeign.getInfo(token);
            if (isSuccess(userInfo)) {
                UserOutDTO data = userInfo.getData();
                if (data != null) {
                    String mobile = data.getMobile();
                    // 对手机号码实现脱敏
                    String desensMobile = mobile.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
                    model.addAttribute("desensMobile", desensMobile);
                }

            }

        }
        return INDEX_FTL;
    }
}
