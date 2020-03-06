<#include "../base/head.ftl"/>
<div class="layui-fulid" id="house-login">
    <div class="layui-form">
        <p>登录 </p>

        <div class="layui-input-block login">
            <i class="layui-icon layui-icon-username"></i>
            <input type="text" required lay-verify="required" placeholder="请输入手机号码" class="layui-input">
        </div>

        <div class="layui-input-block login">
            <i class="layui-icon layui-icon-vercode"></i>
            <input type="text" required lay-verify="required" placeholder="请输入密码" class="layui-input">
        </div>

        <div class="layui-input-block getCode">
            <input type="text" required lay-verify="required" placeholder="请输入验证码" class="layui-input">
            <button class="layui-btn">获取验证码</button>
        </div>
        <button class="layui-btn" lay-submit lay-filter="user-login">登录</button>
    </div>
</div>

<#include "../base/bottom.ftl"/>

</html>