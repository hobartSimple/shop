<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page errorPage="true"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/public/taglibs.jspf" %>
	<%@ include file="/public/head.jspf"%>
	<!--解决 IE6 背景缓存-->
	<!--[if IE 6]>
		<script type="text/javascript">
			document.execCommand("BackgroundImageCache", false, true);
		</script>
	<![endif]-->
	<link rel="stylesheet" href="${shop}/css/error.css" />
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
			<a href="#">
				<img class="fade" src="${shop }/images/404_icon.png">
			</a>
			<div>
				<h1 class="fade">温馨提示：您访问的地址不存在！</h1>
				<p class="fade">
					你正在寻找的页面无法找到。
					<a style="opacity: 1;" class="link" href="#" onclick="history.go(-1)">返回</a>
				</p>
			</div>
			<!-- 底部栏 -->
			<%@include file="/public/bottom.jspf"%>
			<!--底部结束-->
		</div>
	</div>
</body>
</html>
