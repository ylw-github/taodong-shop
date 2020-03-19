<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>淘东商城</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="../static/res/layui/css/layui.css">
    <link rel="stylesheet" href="../static/res/static/css/index.css">
    <script src="../static/res/static/js/jquery.min.js"></script>
    <script type="text/javascript">

        function logout() {
            $.ajax({
                type: "delete",
                url: "exit",
                contentType: "application/json",
                dataType: "json",
                success: function (result) {
                    window.location.href = "/";
                },
                error: function (result) {
                }
            });
        }

    </script>
</head>
<body>

<div class="house-header">
    <div class="layui-container">
        <div class="house-nav">
      <span class="layui-breadcrumb" lay-separator="|">
           <#if desensMobile??>
               <a href="">${desensMobile}</a>
               <a href="">我的订单</a>
               <a href="javascript:void(0);" onclick="logout();">退出</a>
           <#else >
               <a href="login">登录</a>
           </#if>
        <a href="">我的订单</a>
        <a href="">在线客服</a>
      </span>
            <span class="layui-breadcrumb house-breadcrumb-icon" lay-separator=" ">
        <a id="search"><i class="layui-icon layui-icon-house-find"></i></a>
        <a href="login"><i class="layui-icon layui-icon-username"></i></a>
        <a href="usershop"><i class="layui-icon layui-icon-house-shop"></i></a>
      </span>
        </div>
        <div class="house-banner layui-form">
            <a class="banner" href="/">
                <img src="../static/res/static/img/taodong.png" alt="淘东商城">
            </a>
            <div class="layui-input-inline">
                <input type="text" placeholder="搜索好物" class="layui-input"><i
                        class="layui-icon layui-icon-house-find"></i>
            </div>
            <a class="shop" href="usershop.html"><i class="layui-icon layui-icon-house-shop"></i><span
                        class="layui-badge">1</span></a>
        </div>
        <ul class="layui-nav close">
            <li class="layui-nav-item layui-this"><a href="/">首页</a></li>
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

