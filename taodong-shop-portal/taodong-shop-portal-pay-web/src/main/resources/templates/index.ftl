<#include "base/head.ftl"/>

<div class="scent">
    <div class="scent-order">
        <div class="scent-order-info">
            <strong>商品订单：</strong> <span style="color: #b7b0b0;">${data.orderId}</span>
        </div>

        <div class="scent-order-info">
            <strong>支付金额：</strong> <span
                    style="color: #0ac265; font-size: 15px;"></span><span
                    style="color: red; font-size: 24px;">
						￥${(data.payAmount/100)?string('0.00')}</span><br />
        </div>
        <div class="scent-order-info">
            <strong>订单详情：</strong>
            <hr />
            <div class="scent-order-info-desc">
                <span>商品名称：${data.productName}</span>
            </div>
            <div class="scent-order-info-desc">
                <span>支付订单：${data.paymentId}</span>
            </div>
            <div class="scent-order-info-desc">
                <span>应付金额： ￥${(data.payAmount/100)?string('0.00')} </span>
            </div>
            <div class="scent-order-info-desc">
                <span>购买时间：${currentTime}</span>
            </div>
        </div>
    </div>

    <div class="scent-pay">
        <div class="scent-pay-way">
            <strong>支付方式</strong>
        </div>
        <hr />
        <div class="scent-pay-type">
            <#list paymentChanneList as p>
                <a href="/channel?channelId=${p.channelId}"><button
                            class="layui-btn layui-btn-primary layui-btn-lg">
                        <i class="layui-icon layui-icon-rmb" style="color: #1E9FFF"></i>
                        ${p.channelName}
                    </button></a>
            </#list>
        </div>

    </div>
</div>


<#include "base/bottom.ftl"/>
