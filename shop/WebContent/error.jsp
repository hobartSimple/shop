<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page errorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/public/head.jspf"%>
<!--解决 IE6 背景缓存-->
<!--[if IE 6]>
	<script type="text/javascript">
		document.execCommand("BackgroundImageCache", false, true);
	</script>
<![endif]-->
<style type="text/css">
html {
	background: url(${shop }/images/paper.jpg) !important;
}

a, fieldset, img {
	border: 0;
}

a {
	color: #221919;
	text-decoration: none;
	outline: none;
}

a:hover {
	color: #3366cc;
	text-decoration: underline;
}

body {
	font-size: 24px;
	color: #B7AEB4;
}

body a.link, body h1, body p {
	-webkit-transition: opacity 0.5s ease-in-out;
	-moz-transition: opacity 0.5s ease-in-out;
	transition: opacity 0.5s ease-in-out;
}

#wrapper {
	text-align: center;
	margin: 100px auto;
	width: 594px;
}

a.link {
	text-shadow: 0px 1px 2px white;
	font-weight: 600;
	color: #3366cc;
	opacity: 0;
}

h1 {
	text-shadow: 0px 1px 2px white;
	font-size: 24px;
	opacity: 0;
}

img {
	-webkit-transition: opacity 1s ease-in-out;
	-moz-transition: opacity 1s ease-in-out;
	transition: opacity 1s ease-in-out;
	height: 202px;
	width: 199px;
	opacity: 0;
}

p {
	text-shadow: 0px 1px 2px white;
	font-weight: normal;
	font-weight: 200;
	opacity: 0;
}

.fade {
	opacity: 1;
}

@media only screen and (min-device-width:320px) and
	(max-device-width:480px) {
	#wrapper {
		margin: 40px auto;
		text-align: center;
		width: 280px;
	}
}
</style>
</head>
<body>
	<div id="wrapper">
		<!--头部开始-->
		<%@include file="/public/top.jspf"%>
		<!-- 头部结束 -->
		<!-- 导航栏 -->
		<div class="navigation_container">
			<!---->
			<%@include file="/public/left.jspf"%>
		</div>
		<!--导航栏结束-->
		<div class="section_container">
			<a href="#"><img class="fade" src="${shop }/images/404_icon.png"></a>
			<div>
				<h1 class="fade">温馨提示：您访问的地址不存在！</h1>
				<p class="fade">
					你正在寻找的页面无法找到。 <a style="opacity: 1;" class="link" href="#"
						onclick="history.go(-1)">返回</a>
				</p>
			</div>
			<!-- 底部栏 -->
			<%@include file="/public/bottom.jspf"%>
			<!--底部结束-->
		</div>
	</div>
</body>
</html>
