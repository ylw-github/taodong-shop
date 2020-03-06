<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>淘东商城</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="../res/layui/css/layui.css">
    <link rel="stylesheet" href="../res/static/css/register.css">
</head>
<body>

<div class="house-header">
    <div class="layui-container">
        <div class="house-nav">
      <span class="layui-breadcrumb" lay-separator="|">
        <a href="login.html">登录</a>
        <a href="">我的订单</a>
        <a href="">在线客服</a>
      </span>
            <span class="layui-breadcrumb house-breadcrumb-icon" lay-separator=" ">
        <a id="search"><i class="layui-icon layui-icon-house-find"></i></a>
        <a href="login.html"><i class="layui-icon layui-icon-username"></i></a>
        <a href="usershop.html"><i class="layui-icon layui-icon-house-shop"></i></a>
      </span>
        </div>
        <div class="house-banner layui-form">
            <a class="banner" href="index.html">
                <img src="../res/static/img/taodong.png" alt="淘东商城">
            </a>
            <div class="layui-input-inline">
                <input type="text" placeholder="搜索好物" class="layui-input"><i
                        class="layui-icon layui-icon-house-find"></i>
            </div>
            <a class="shop" href="usershop.html"><i class="layui-icon layui-icon-house-shop"></i><span
                        class="layui-badge">1</span></a>
        </div>
        <ul class="layui-nav close">
            <li class="layui-nav-item layui-this"><a href="index.html">首页</a></li>
            <li class="layui-nav-item"><a href="list.html">新鲜水果</a></li>
            <li class="layui-nav-item"><a href="list.html">海鲜水产</a></li>
            <li class="layui-nav-item"><a href="list.html">精选肉类</a></li>
            <li class="layui-nav-item"><a href="list.html">冷饮冻食</a></li>
            <li class="layui-nav-item"><a href="list.html">蔬菜蛋品</a></li>
        </ul>
        <button id="switch">
            <span></span><span class="second"></span><span class="third"></span>
        </button>
    </div>
</div>

<div class="layui-fulid" id="house-login">
    <div class="layui-form">
        <p>注册</p>
        <div class="layui-input-block login">
            <i class="layui-icon layui-icon-username"></i> <input type="text"
                                                                  required lay-verify="required" placeholder="请输入手机号码"
                                                                  class="layui-input">
        </div>

        <div class="layui-input-block login" style="margin-top: 12px;">
            <i class="layui-icon layui-icon-vercode"></i> <input type="text"
                                                                 required lay-verify="required" placeholder="请输入密码"
                                                                 class="layui-input">
        </div>


        <div class="layui-input-block-weixinQRcode" style="text-align: center;">
            <img alt="" src="../res/static/img/qrcode.jpg">

            <div style="text-align: center; font-size: 14px; color: #FF5722;">
                关注微信公众号,发送手机号码可获得注册码
            </div>
        </div>


        <div class="layui-input-block login" style="margin-top: 12px;">
            <i class="layui-icon layui-icon-vercode"></i> <input type="text"
                                                                 required lay-verify="required" placeholder="请输入微信注册码"
                                                                 class="layui-input">
        </div>


        <div class="layui-input-block getCode" style="margin-top: 12px;">
            <input type="text" name="graphicCode"
                   value="${(registerVo.graphicCode)!''}" placeholder="请输入验证码" class="layui-input">
            <img alt="" src="getVerify" onclick="getVerify(this);"
                 style="border: 1px solid #e2e2e2; font-size: 18px; height: 46px; margin-top: -69px; width: 44%; background-color: #e8d6c0; margin-left: 167px;">
        </div>
        <button class="layui-btn" lay-submit lay-filter="user-login" style="margin-top: 5px;">注册</button>
    </div>
</div>

<#include "../base/bottom.ftl"/>

<script>
    //获取验证码
    function getVerify(obj) {
        obj.src = "getVerify?" + Math.random();
    }
</script>