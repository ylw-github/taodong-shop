var ua = navigator.userAgent;

var ipad = ua.match(/(iPad).*OS\s([\d_]+)/),

    isIphone = !ipad && ua.match(/(iPhone\sOS)\s([\d_]+)/),

    isAndroid = ua.match(/(Android)\s+([\d.]+)/),

    isMobile = isIphone || isAndroid;

if (isMobile) {
    $(".head-center").css("margin-left", "12px");
    $(".head-center-user").hide();
    $(".scent").css({
        "width": "96%",
        "margin": "14px auto"
    });
    $(".scent-order").css({
        "width": "100%",
        "height": "48%",
        "margin-top": "0px",
        "margin-left": "-80px"
    });
    $(".scent-order-info").css("width", "100%");
    $(".scent-pay").css({
        "width": "84%",
        "margin-top": "2px",
        "height": "340px"
    })
    $("#weixin").hide();
    $("#wx").css("margin-top", "-32px")
    $(".footer").css("font-size", "14px")
    console.log("手机版本充值...")
} else {
    console.log("电脑版本充值...")
}

