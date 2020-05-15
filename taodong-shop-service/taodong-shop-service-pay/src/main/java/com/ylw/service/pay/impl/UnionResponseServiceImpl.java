package com.ylw.service.pay.impl;

import com.unionpay.acp.sdk.AcpService;
import com.unionpay.acp.sdk.LogUtil;
import com.unionpay.acp.sdk.SDKConstants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * description: 银联前台通知和后台通知地址
 * create by: YangLinWei
 * create time: 2020/5/15 11:04 上午
 */
@Controller
public class UnionResponseServiceImpl {


    @RequestMapping("/frontRcvResponse")
    @ResponseBody
    public String frontRcvResponse(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        LogUtil.writeLog("FrontRcvResponse前台接收报文返回开始");

        String encoding = req.getParameter(SDKConstants.param_encoding);
        LogUtil.writeLog("返回报文中encoding=[" + encoding + "]");
        String pageResult = "";
        Map<String, String> respParam = getAllRequestParam(req);

        // 打印请求报文
        LogUtil.printRequestLog(respParam);

        Map<String, String> valideData = null;
        StringBuffer page = new StringBuffer();
        if (null != respParam && !respParam.isEmpty()) {
            Iterator<Map.Entry<String, String>> it = respParam.entrySet()
                    .iterator();
            valideData = new HashMap<String, String>(respParam.size());
            while (it.hasNext()) {
                Map.Entry<String, String> e = it.next();
                String key = (String) e.getKey();
                String value = (String) e.getValue();
                value = new String(value.getBytes(encoding), encoding);
                page.append("<tr><td width=\"30%\" align=\"right\">" + key
                        + "(" + key + ")</td><td>" + value + "</td></tr>");
                valideData.put(key, value);
            }
        }
        if (!AcpService.validate(valideData, encoding)) {
            page.append("<tr><td width=\"30%\" align=\"right\">验证签名结果</td><td>失败</td></tr>");
            LogUtil.writeLog("验证签名结果[失败].");
        } else {
            page.append("<tr><td width=\"30%\" align=\"right\">验证签名结果</td><td>成功</td></tr>");
            LogUtil.writeLog("验证签名结果[成功].");
            System.out.println(valideData.get("orderId")); //其他字段也可用类似方式获取

            String respCode = valideData.get("respCode");
            //判断respCode=00、A6后，对涉及资金类的交易，请再发起查询接口查询，确定交易成功后更新数据库。
        }
        return page.toString();
    }


    @RequestMapping("/BackRcvResponse")
    @ResponseBody
    public String BackRcvResponse(HttpServletRequest req, HttpServletResponse resp) {
        LogUtil.writeLog("BackRcvResponse接收后台通知开始");

        String encoding = req.getParameter(SDKConstants.param_encoding);
        // 获取银联通知服务器发送的后台通知参数
        Map<String, String> reqParam = getAllRequestParam(req);
        LogUtil.printRequestLog(reqParam);

        //重要！验证签名前不要修改reqParam中的键值对的内容，否则会验签不过
        if (!AcpService.validate(reqParam, encoding)) {
            LogUtil.writeLog("验证签名结果[失败].");
            //验签失败，需解决验签问题

        } else {
            LogUtil.writeLog("验证签名结果[成功].");
            //【注：为了安全验签成功才应该写商户的成功处理逻辑】交易成功，更新商户订单状态

            String orderId =reqParam.get("orderId"); //获取后台通知的数据，其他字段也可用类似方式获取
            String respCode = reqParam.get("respCode");
            //判断respCode=00、A6后，对涉及资金类的交易，请再发起查询接口查询，确定交易成功后更新数据库。

        }
        LogUtil.writeLog("BackRcvResponse接收后台通知结束");
        //返回给银联服务器http 200  状态码
        return "ok";
    }
    /**
     * 获取请求参数中所有的信息
     * 当商户上送frontUrl或backUrl地址中带有参数信息的时候，
     * 这种方式会将url地址中的参数读到map中，会导多出来这些信息从而致验签失败，这个时候可以自行修改过滤掉url中的参数或者使用getAllRequestParamStream方法。
     * @param request
     * @return
     */
    public static Map<String, String> getAllRequestParam(
            final HttpServletRequest request) {
        Map<String, String> res = new HashMap<String, String>();
        Enumeration<?> temp = request.getParameterNames();
        if (null != temp) {
            while (temp.hasMoreElements()) {
                String en = (String) temp.nextElement();
                String value = request.getParameter(en);
                res.put(en, value);
                // 在报文上送时，如果字段的值为空，则不上送<下面的处理为在获取所有参数数据时，判断若值为空，则删除这个字段>
                if (res.get(en) == null || "".equals(res.get(en))) {
                    // System.out.println("======为空的字段名===="+en);
                    res.remove(en);
                }
            }
        }
        return res;
    }

}
