<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>淘东商城</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="../static/res/layui/css/layui.css">
    <link rel="stylesheet" href="../static/res/static/css/index.css">
    <script src="../static/res/static/js/jquery.min.js"></script>
</head>
<body>
<div class="layui-fulid" id="house-login">
    <form action="doLogin" method="post">
        <div class="layui-form">
            <p>手机号登录</p>

            <div class="layui-input-block login">
                <i class="layui-icon layui-icon-username"></i> <input type="text"
                                                                      required lay-verify="required" name="mobile"
                                                                      value="${(loginVo.mobile)!''}"
                                                                      placeholder="请输入手机号码"
                                                                      class="layui-input">
            </div>

            <div class="layui-input-block login">
                <i class="layui-icon layui-icon-vercode"></i> <input
                        type="password" required lay-verify="required" name="password"
                        value="${(loginVo.password)!''}" placeholder="请输入密码"
                        class="layui-input">
            </div>

            <div class="layui-input-block getCode">
                <input type="text" name="graphicCode" required lay-verify="required"
                       placeholder="请输入验证码" class="layui-input"> <img alt=""
                                                                      src="getVerify" onclick="getVerify(this);"
                                                                      style="border: 1px solid #e2e2e2;font-size: 18px;height: 48px;margin-top: -93px;width: 44%;background-color: #e8d6c0;margin-left: 166px;">
            </div>
            <span style="color: red; font-size: 20px; font-weight: bold; font-family: '楷体', '楷体_GB2312';">${error!''}</span>
            <input type="hidden" name="redirect_url" value="${RequestParameters['redirect_url']!''}" />
            <button class="layui-btn" style="margin-top: 5px;" lay-submit lay-filter="user-login">登录</button>
        </div>
    </form>
</div>

<#include "base/bottom.ftl"/>