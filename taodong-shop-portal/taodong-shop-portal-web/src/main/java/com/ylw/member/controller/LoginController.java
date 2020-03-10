package com.ylw.member.controller;

import com.alibaba.fastjson.JSONObject;
import com.ylw.api.member.dto.intput.UserLoginInDTO;
import com.ylw.common.web.core.base.BaseWebController;
import com.ylw.common.web.core.constants.Constants;
import com.ylw.common.web.core.constants.WebConstants;
import com.ylw.common.web.core.entity.BaseResponse;
import com.ylw.common.web.core.util.CookieUtils;
import com.ylw.common.web.core.util.RandomValidateCodeUtil;
import com.ylw.common.web.core.util.WebBeanUtils;
import com.ylw.member.controller.req.vo.LoginVo;
import com.ylw.member.feign.MemberLoginServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * description: 登录页
 * create by: YangLinWei
 * create time: 2020/3/5 1:48 下午
 */
@Controller
public class LoginController extends BaseWebController {
    /**
     * 跳转到登陆页面页面
     */
    private static final String MB_LOGIN_FTL = "member/login";

    @Autowired
    private MemberLoginServiceFeign memberLoginServiceFeign;
    /**
     * 重定向到首页
     */
    private static final String REDIRECT_INDEX = "redirect:/";

    /**
     * 跳转页面
     *
     * @return
     */
    @GetMapping("/login")
    public String getLogin() {
        return MB_LOGIN_FTL;
    }

    /**
     * 接受请求参数
     *
     * @return
     */
    @PostMapping("/login")
    public String postLogin(@ModelAttribute("loginVo") @Validated LoginVo loginVo,
							BindingResult bindingResult, Model model, HttpServletRequest request,
                            HttpServletResponse response, HttpSession httpSession) {

        if (bindingResult.hasErrors()) {
            // 如果参数有错误的话
            // 获取第一个错误!
            String errorMsg = bindingResult.getFieldError().getDefaultMessage();
            setErrorMsg(model, errorMsg);
            return MB_LOGIN_FTL;
        }

        // 1.图形验证码判断
        String graphicCode = loginVo.getGraphicCode();
        if (!RandomValidateCodeUtil.checkVerify(graphicCode, httpSession)) {
            setErrorMsg(model, "图形验证码不正确!");
            return MB_LOGIN_FTL;
        }

        // 2.将vo转换dto调用会员登陆接口
        UserLoginInDTO userLoginInpDTO = WebBeanUtils.voToDto(loginVo, UserLoginInDTO.class);
        userLoginInpDTO.setLoginType(Constants.MEMBER_LOGIN_TYPE_PC);
        String info = webBrowserInfo(request);
        userLoginInpDTO.setDeviceInfor(info);
        BaseResponse<JSONObject> login = memberLoginServiceFeign.login(userLoginInpDTO);
        if (!isSuccess(login)) {
            setErrorMsg(model, login.getMsg());
            return MB_LOGIN_FTL;
        }
        // 3.登陆成功之后如何处理 保持会话信息 将token存入到cookie 里面 首页读取cookietoken 查询用户信息返回到页面展示
        JSONObject data = login.getData();
        String token = data.getString("token");
        CookieUtils.setCookie(request, response, WebConstants.LOGIN_TOKEN_COOKIENAME, token);
        return REDIRECT_INDEX;
    }

}
