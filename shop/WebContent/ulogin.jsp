<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<%@ include file="/public/taglibs.jspf" %>
	<%@ include file="/public/head.jspf"%>
	<style type="text/css">
	#dd div {
		padding: 5px;
	}
	</style>
<body>
	<div class="wrapper">
		<!--头部开始-->
		<%@include file="/public/top.jspf"%>
		<!-- 头部结束 -->
		<!-- 导航栏 -->
		<%@include file="/public/left.jspf"%>
		<!--导航栏结束-->
		<div class="section_container">
			<!-- 购物车 -->
			<div id="dd" class="action_buttonbar" style="text-align: center;">
				<form method="post" action="${shop}/user_login">
					<div>
						<label for="login">账号:&nbsp;</label>
						<input type="text" name="login" />
					</div>
					<div>
						<label for="pass">密码:&nbsp;</label>
						<input type="password" name="pass" />
					</div>
					<div>${sessionScope.error}</div>
					<div>
						<input type="submit" value="登陆" style="width: 60px; height: 30px" />
						<input type="button" value="注册" onclick="window.open('${shop}/index.jsp','_self')" style="width: 60px; height: 30px" />
					</div>
				</form>
				<div style="clear: both"></div>
			</div>
		</div>
		<!-- 导航栏结束 -->
		<!-- 底部栏 -->
		<%@include file="/public/bottom.jspf"%>
		<!--底部结束-->
	</div>
</body>
</html>
