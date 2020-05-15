package com.ylw.portal.pay.web;

import com.alibaba.fastjson.JSONObject;
import com.xxl.sso.core.conf.Conf;
import com.xxl.sso.core.user.XxlSsoUser;
import com.ylw.api.member.dto.output.UserOutDTO;
import com.ylw.api.pay.dto.dto.PayMentTransacDTO;
import com.ylw.api.pay.dto.dto.PaymentChannelDTO;
import com.ylw.common.web.core.base.BaseWebController;
import com.ylw.common.web.core.entity.BaseResponse;
import com.ylw.feign.PayContextFeign;
import com.ylw.feign.PayMentTransacInfoFeign;
import com.ylw.feign.PaymentChannelFeign;
import com.ylw.member.feign.MemberServiceFeign;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * description: 支付
 * create by: YangLinWei
 * create time: 2020/5/13 1:35 下午
 */
@Controller
public class PayController extends BaseWebController {
    @Autowired
    private PayMentTransacInfoFeign payMentTransacInfoFeign;

    @Autowired
    private PaymentChannelFeign paymentChannelFeign;

    @Autowired
    private MemberServiceFeign memberServiceFeign;

    @Autowired
    private PayContextFeign payContextFeign;

    /**
     * 跳转到index页面
     */
    private static final String INDEX_FTL = "index";

    @RequestMapping("/pay")
    public String pay(HttpServletRequest request, String payToken, Model model) {
        // 1.验证payToken参数
        if (StringUtils.isEmpty(payToken)) {
            setErrorMsg(model, "支付令牌不能为空!");
            return ERROR_500_FTL;
        }
        // 2.使用payToken查询支付信息
        BaseResponse<PayMentTransacDTO> tokenByPayMentTransac = payMentTransacInfoFeign.tokenByPayMentTransac(payToken);
        if (!isSuccess(tokenByPayMentTransac)) {
            setErrorMsg(model, tokenByPayMentTransac.getMsg());
            return ERROR_500_FTL;
        }
        // 3.查询支付信息
        PayMentTransacDTO data = tokenByPayMentTransac.getData();
        model.addAttribute("data", data);
        // 4.查询渠道信息
        List<PaymentChannelDTO> paymentChanneList = paymentChannelFeign.selectAll();
        model.addAttribute("paymentChanneList", paymentChanneList);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        model.addAttribute("currentTime", sdf.format(new Date()));
        model.addAttribute("payToken", payToken);

        //5.设置当前用户
        XxlSsoUser xxlUser = (XxlSsoUser) request.getAttribute(Conf.SSO_USER);

        if (xxlUser != null && StringUtils.isNotEmpty(xxlUser.getUserid())) {
            // 2.调用会员服务接口,查询会员用户信息
            BaseResponse<UserOutDTO> userInfo = memberServiceFeign.getInfo(xxlUser.getUserid());
            if (isSuccess(userInfo)) {
                UserOutDTO userData = userInfo.getData();
                if (data != null) {
                    String mobile = userData.getMobile();
                    // 对手机号码实现脱敏
                    String desensMobile = mobile.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
                    model.addAttribute("desensMobile", desensMobile);
                }
            }
        }

        return INDEX_FTL;
    }

    @RequestMapping("/channel")
    @ResponseBody
    public String channel(String channelId, String payToken) {
        return payContextFeign.toPayHtml(channelId, payToken);
    }

    @RequestMapping("/test-xxl1")
    @ResponseBody
    public String test(String channelId, String payToken) {
        return "test-xxl1";
    }

    @RequestMapping("/test-xxl2")
    @ResponseBody
    public String test1(String channelId, String payToken) {
        return "test-xxl2";
    }

}
