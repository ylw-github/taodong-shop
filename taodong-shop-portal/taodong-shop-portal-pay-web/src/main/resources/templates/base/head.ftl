<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>淘东收银台</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="../res/layui/css/layui.css">
    <link rel="stylesheet" href="../res/static/css/index.css">
    <link rel="stylesheet" href="../res/static/css/pay.css">
    <script src="../res/static/js/jquery.min.js"></script>
    <script src="../res/static/js/pay.js"></script>
    <script type="text/javascript">

        function logout() {
            $.ajax({
                type: "delete",
                //url: "exit",
                url: "ssoExit",
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
            <a href="">充值中心</a>
            <a href="">${desensMobile}</a>
            <a href="javascript:void(0);" onclick="logout();">退出</a>
        <#else >
            <a href="login">登录</a>
        </#if>
        <a href="">在线客服</a>
    </span>
            <span class="layui-breadcrumb house-breadcrumb-icon" lay-separator=" ">
        <a id="search"><i class="layui-icon layui-icon-house-find"></i></a>
        <a href="login"><i class="layui-icon layui-icon-username"></i></a>
        <a href="usershop"><i class="layui-icon layui-icon-house-shop"></i></a>
    </span>
        </div>
    </div>
</div>

