/**
 * 主界面商品遍历
 */

// 转义 HTML 特殊字符
function escapeHtml(value) {
    return String(value == null ? "" : value)
        .replace(/&/g, "&amp;")
        .replace(/</g, "&lt;")
        .replace(/>/g, "&gt;")
        .replace(/"/g, "&quot;")
        .replace(/'/g, "&#39;");
}

// 查询商品
function loadCommodity(type){
	$.ajax({
        // 使用 JSP 中定义的项目路径
		url: contextPath + "/CommodityServlet",
        type: "post",
        dataType: "json",
        data: {
            opt: type === "" ? "selectAllCommodityList" : "selectCommodityByType",
            type: type
        },

        success: function (data) {

            console.log("后台返回的数据：", data);

            var html = "";

            // 遍历后台返回的商品数组
            $.each(data, function (i, com) {

                html +=
                    '<div class="div_context">' +

                        '<div class="div_context_l">' +
                            '<img src="' +
                                escapeHtml(com.commodity_img) +
                            '" width="350px" height="260px" alt="保险商品图片">' +
                        '</div>' +

                        '<div class="div_context_r">' +

                            '<div class="div_context_r_1">' +
                                '<h2>' +
                                    escapeHtml(com.commodity_name) +
                                '</h2>' +

                                '<p class="p1">' +
                                    escapeHtml(com.commodity_introduce) +
                                '</p >' +

                                '<p class="p2">専門の家庭医、重病VIPサービス</p >' +
                            '</div>' +

                            '<div class="div_context_r_2">' +
                                '<div class="price">' +
                                    '<span class="fh"><b>¥</b></span>' +
                                    '<span class="price_a"><b>' +
                                        escapeHtml(com.commodity_price) +
                                    '</b></span>' +
                                    '<span class="fh"><b>/起</b></span>' +
                                '</div>' +

								'<a href="' + contextPath +
								    '/CommodityServlet?opt=commodityQueryById&commodity_id=' +
								    encodeURIComponent(com.commodity_id) + '">' +
								    '<div class="img_a"><b>詳細はこちら</b></div>' +
								'</a >' +

                            '</div>' +
                        '</div>' +
                    '</div>';
            });

            // 显示商品
            if (html === "") {
                $("#context_text").html("<p>暂无保险商品</p >");
            } else {
                $("#context_text").html(html);
            }
        },
		
		error:function(){
			alert("ネットワークにエラーがありました。後で再試行してください！");
		}
	});
}

$(function () {

    // 默认查询全部保险
    loadCommodity("");
	
	// 点击全部
	$("#all").click(function(){
		loadCommodity("");
	});
	
	$("#jiankang").click(function(){
		loadCommodity("1");
	});

	$("#yiwai").click(function(){
		loadCommodity("2");
	});
	
	$("#qiye").click(function(){
		loadCommodity("3");
	});
	
	$("#lvxing").click(function(){
		loadCommodity("4");
	});
	
	$("#jiaji").click(function(){
		loadCommodity("5");
	});	
	
	$("#userInfo").click(function(){
		window.location.href=contextPath+"/UserServlet?opt=userInfo";
	});
	
});