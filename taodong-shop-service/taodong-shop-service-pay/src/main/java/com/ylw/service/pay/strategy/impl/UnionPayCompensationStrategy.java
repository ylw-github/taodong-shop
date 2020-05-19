package com.ylw.service.pay.strategy.impl;

import com.alibaba.fastjson.JSONObject;
import com.unionpay.acp.sdk.AcpService;
import com.unionpay.acp.sdk.LogUtil;
import com.unionpay.acp.sdk.SDKConfig;
import com.unionpay.acp.sdk.UnionPayBase;
import com.ylw.common.web.core.api.BaseApiService;
import com.ylw.service.pay.constant.PayConstant;
import com.ylw.service.pay.mapper.PaymentTransactionMapper;
import com.ylw.service.pay.mapper.entity.PaymentChannelEntity;
import com.ylw.service.pay.mapper.entity.PaymentTransactionEntity;
import com.ylw.service.pay.strategy.PaymentCompensationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * description: 银联对账策略者实现
 * create by: YangLinWei
 * create time: 2020/5/19 9:31 上午
 */
@Component
public class UnionPayCompensationStrategy extends BaseApiService<JSONObject> implements PaymentCompensationStrategy {
    @Autowired
    private PaymentTransactionMapper paymentTransactionMapper;

    @Override
    public Boolean payMentCompensation(PaymentTransactionEntity paymentTransaction,
                                       PaymentChannelEntity paymentChanne) {
        // 1.商户号码
        String merchantId = paymentChanne.getMerchantId();
        // 2.下单时间
        Date createdTime = paymentTransaction.getCreatedTime();
        // 3.支付id
        String paymentId = paymentTransaction.getPaymentId();
        // 4.调用银联支付接口
        Boolean unionPayCompensation = unionPayCompensation(paymentId, format(createdTime), merchantId);

        return unionPayCompensation;
    }

    private Boolean unionPayCompensation(String orderId, String txnTime, String merchantId) {

        Map<String, String> data = new HashMap<String, String>();

        /*** 银联全渠道系统，产品参数，除了encoding自行选择外其他不需修改 ***/
        data.put("version", UnionPayBase.version); // 版本号
        data.put("encoding", UnionPayBase.encoding); // 字符集编码 可以使用UTF-8,GBK两种方式
        data.put("signMethod", SDKConfig.getConfig().getSignMethod()); // 签名方法
        data.put("txnType", "00"); // 交易类型 00-默认
        data.put("txnSubType", "00"); // 交易子类型 默认00
        data.put("bizType", "000201"); // 业务类型 B2C网关支付，手机wap支付

        /*** 商户接入参数 ***/
        data.put("merId", merchantId); // 商户号码，请改成自己申请的商户号或者open上注册得来的777商户号测试
        data.put("accessType", "0"); // 接入类型，商户接入固定填0，不需修改

        /*** 要调通交易以下字段必须修改 ***/
        data.put("orderId", orderId); // ****商户订单号，每次发交易测试需修改为被查询的交易的订单号
        data.put("txnTime", txnTime); // ****订单发送时间，每次发交易测试需修改为被查询的交易的订单发送时间

        /** 请求参数设置完毕，以下对请求参数进行签名并发送http post请求，接收同步应答报文-------------> **/

        Map<String, String> reqData = AcpService.sign(data, UnionPayBase.encoding);// 报文中certId,signature的值是在signData方法中获取并自动赋值的，只要证书配置正确即可。

        String url = SDKConfig.getConfig().getSingleQueryUrl();// 交易请求url从配置文件读取对应属性文件acp_sdk.properties中的
        // acpsdk.singleQueryUrl
        // 这里调用signData之后，调用submitUrl之前不能对submitFromData中的键值对做任何修改，如果修改会导致验签不通过
        Map<String, String> rspData = AcpService.post(reqData, url, UnionPayBase.encoding);

        /** 对应答码的处理，请根据您的业务逻辑来编写程序,以下应答码处理逻辑仅供参考-------------> **/
        // 应答码规范参考open.unionpay.com帮助中心 下载 产品接口规范 《平台接入接口规范-第5部分-附录》
        if (!rspData.isEmpty()) {
            if (AcpService.validate(rspData, UnionPayBase.encoding)) {
                LogUtil.writeLog("验证签名成功");
                if ("00".equals(rspData.get("respCode"))) {// 如果查询交易成功
                    // 处理被查询交易的应答码逻辑
                    String origRespCode = rspData.get("origRespCode");
                    if ("00".equals(origRespCode)) {
                        // 交易成功，更新商户订单状态
                        // 2.将状态改为已经支付成功
                        paymentTransactionMapper.updatePaymentStatus(PayConstant.PAY_STATUS_SUCCESS + "", orderId,"yinlian_pay");
                        // 3.调用积分服务接口增加积分(处理幂等性问题)
                        return true;
                    } else if ("03".equals(origRespCode) || "04".equals(origRespCode) || "05".equals(origRespCode)) {
                        // 需再次发起交易状态查询交易
                        // TODO
                    } else {
                        // 其他应答码为失败请排查原因
                        // TODO
                    }
                } else {// 查询交易本身失败，或者未查到原交易，检查查询交易报文要素
                    // TODO
                }
            } else {
                LogUtil.writeErrorLog("验证签名失败");
                // TODO 检查验证签名失败的原因
            }
        } else {
            // 未返回正确的http状态
            LogUtil.writeErrorLog("未获取到返回报文或返回http状态码非200");
        }
        return false;

    }

    private String format(Date timeDate) {
        String date = new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(timeDate);
        return date;
    }
}
