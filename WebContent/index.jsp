<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>健康保険のホームページ</title>
		<link rel="stylesheet" type="text/css" href="css/index.css" />
		<link rel="stylesheet" href="https://at.alicdn.com/t/c/font_3881267_wfv3iyzbijg.css">
		<link rel="stylesheet" href="https://cdn.staticfile.org/font-awesome/4.7.0/css/font-awesome.css">
		<script type="text/javascript" src="js/banner.js"></script>
		<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
		<script type="text/javascript">var contextPath="${pageContext.request.contextPath}";</script>
		<script type="text/javascript" src="js/index.js"></script>
	</head>
	<body>
		<div align="center" id="div_all">
			<div id="top1">
				<div id="top1_text">
					<div id="top1_text1">こんにちは、健康保険モールへようこそ</div>
					<div id="top1_text2">
						<span id="span1">最新情報：</span>
						<marquee id="lb" direction="left">
							ログインしてサインするとプレゼントがあります
						</marquee>
						<c:choose>
							<%--已登录 --%>
							<c:when test="${not empty sessionScope.user }">
								<button type="button" id="userInfo">${sessionScope.user.user_name }先生、こんにちは！</button>
							</c:when>
							<c:otherwise>
								<a href="login.jsp">
									<button type="button" id="userlogin">login/regist</button>
								</a>
							</c:otherwise>
						</c:choose>
						
						
					</div>
				</div>
			</div>
			<div id="top2">
				<div id="top2_text">
					<ul id="top2_text_ul">
						<li id="all"><b>すべての保険</b></li>
						<li id="jiankang"><b>健康保険</b></li>
						<li id="yiwai"><b>意外保険</b></li>
						<li id="qiye"><b>企業保険</b></li>
						<li id="lvxing"><b>旅行保険</b></li>
						<li id="jiaji"><b>家計保険</b></li>
					</ul>
				</div>
			</div>
			<div id="context_all2">
				<div id="banner">
					<div id="banner_text">
					    <section>
					        <img width="1200px" height="350px" src="https://baoxian.pingan.com/uploadfile/clause/image/website/1670833686560.jpg" alt="" id="img">
					        <p class="al"></p>
					    </section>
					</div>
				</div>
				<!-- js动态输出保险信息 -->
				<div id="context">
					<div id="context_text">
						
					</div>
				</div>
				<div id="foot">
					<h5 class="h51">カスタマーサービスホットライン：888-888-8888 （9:00~21:00）</h5>
					<h5 class="h52">○○健康保険株式会社 027-666666 &nbsp;&nbsp; ICP認証：UP9999999 &nbsp;&nbsp; Copyright © 2023 All Rights Reserved</h5>
				</div>
			</div>
		</div>
	</body>
</html>