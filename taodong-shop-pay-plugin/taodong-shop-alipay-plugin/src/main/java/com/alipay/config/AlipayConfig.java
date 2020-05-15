package com.alipay.config;

import java.io.FileWriter;
import java.io.IOException;


/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */
public class AlipayConfig {
    //↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016102400751545";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQC/YOLX2BmwQySAe+sdN0IeU0sT5fXGqa+IjnJYX4IEAOdJhPrY0Be23QL5hmJw1trYHjRqMc2N2TpxVvOx4Wo0sit5QiWmUhwj5EFnPh3WtIheaysF80jo3TxXOrAy2b5odNVQPcwGEAyVLgV5P5GlPhXwjpAYPvR3MewuxOC0xy05yqhs51Uhc/+MEhrCpeYIC+zoNNM/cTMcWbGHDDxNZHpYsekXHtdp+MRTkwKVC4OHoqYZVqnMhEY9hyc6Kpp4DAKICGFXFbjagUBze2tSqwlXQhScgTTdr2IYwxbiG7rhw1UGx6eygcqpAjezTgdMATnf4VrYjs6q05d6J4JhAgMBAAECggEBAIQ7C0Gb3NP+8F+eP2tmXNbbMkrDXzgu0kwGMFeDVjAx95zCtxfLYDdHKeECy02wBnHBHPIrCx3xdAIP1D2ZxGo4mPUlkSIEJdFeyxnsv200O+0RGx73Y+8Rvbl/oXLhJEDESQcyS5/8wtTogXuvQpDr/vjBaCp4hS0+XzRJcAE3U2x5z2kTAwVpsnNFOzVPzn9gzPT+u1jA5epcqAZKGwci49VBA0tzfhn5kvQGFl8sLAqaKbvGAoumC1pzCNOuUeu54umNghnBiB0e61EnZvd8gunBCfUUlc+DCCvUOZkyn+Rapm8Vzt+bgpxQdOrzCQAwoSZ37bj6TdgQah8S3GECgYEA6SyjxiynqjwGdvC+Kjp95pe0Wx4dpG1HfnJHG+vX4cTgnpBcfb2kvYfof89WNABphny38YqPjlj32yO5GfXlGCtF5T9jH8L9Sf2REESQtMLVuQDVcq/MTpA2MSol/yzeZez27tEda1QfgqDijJ0wbqIeLhCAXibijJYQe8rMnj0CgYEA0hzWw3rWujy/RaoQBwp2eAsGU85X/gMKldWlb77PK/+OB36KODSoPGIsPFgLUHemafU01OJzT1FxiUDp0Hzpp2ACD2EiSkFMBBaNblwPsogUZJNS3Zz6fRo8qr978abyRTYjWFODjhkx117dR0WyBcegThuPDOctVVLKWtZHevUCgYAyN1zl9wP804SI5PvvWD15Bb7fyLKVkLtO7gmGZ9pMUvwU6f4hTlBGSRi3Pc3Q0S3our9ak36rJ1nppd3dS2mVNOyOnIIaewHVh3hQSpPnefZRK27MjjOvz7r8B5m7RMx4ovnjIMH3NVy74y4nHksp6Fwbi445uKIdqMvP/TLn+QKBgGML8TmpOHwGkuwWJQQMrJgeKldrWBOH/39ufVRWEHdfOubRgfrI592/MbcokfzWyn38d3E7ZrwnWmwnS5FasRKTsaTqVy3F5j2vG/DAOS4h8+sNf+y0SWib66laJuVdm6uAv9ytUcC0o8gxEgK9GhSbbDglyaN9fuNP6dA0XvHZAoGBAI0O7lBBwEmXXZU9KpkfZvFgdHiMcm+lks0FS40LFuciPykDSNsP8UvZzNC+tqjBYzZ203XdiPfLpWlLXwrQOlhCfUGG28kw3P5SgQioY7qWO51zamt/yuAUjh9Nz+gSdqZD8tW3f//F4P3nmohED1quNs0cIkAR5MicahneUDSI";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEArWgHOtQcvXLJgbseyOtkw5La74UnHQlZ2eu988D099KpjUhWCagCCaGgXQomaT1Ku8y/49p0vS3mamZ/VYZvt9EFQvSLKvpjVr3dLoUg/kT5pVhe7iUG8lvMw2LNfmNyv7r8qGyY/ggEjWVjKeUo74sk/uhPwS7ZM52APxcJem9JNdxmtRAD4qltgzeeJUR+kZbESYJoQFrIkJsPIKSJP1CbusHC321igPUx4zEDuMOej5ePa6glaId0t0x23JknoAqwMjF8QUgS1Y/3/6UjhDFdgpt2XN99JD1dQoQO/nKrKSRCKUXI56JEppkfZkJKQEAL8mfj/JF5p6gqcnwQqwIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
