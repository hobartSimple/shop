<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/public/taglibs.jspf" %>
<%@ include file="/public/head.jspf"%>
</head>
<body>
	<div class="wrapper">
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
			<!--左侧导航-->
			<div id="side_nav">
				<div class="sideNavCategories">
					<h1>女装</h1>
					<ul class="category departments">
						<li class="header">分类</li>
						<li><a href="#">毛衣</a></li>
						<li><a href="#">针织衫 </a></li>
						<li><a href="#">衬衫 </a></li>
						<li><a href="#">T恤</a></li>
						<li><a href="#">短裤</a></li>
						<li><a href="#">牛仔 </a></li>
						<li><a href="#">连身裙</a></li>
						<li><a href="#">短裙 </a></li>
					</ul>
				</div>

			</div>
			<!-- 右侧焦点图区域 -->
			<div id="main_content ">
				<div>
					<img src="images/lm_banner_1.jpg" />
				</div>
			</div>
		</div>


		<!-- 产品列表 -->
		<c:forEach items="${applicationScope.bigList}" var="list">
			<div class="products_list products_slider clear">
				<!-- 显示类别名称 -->
				<h2 class="sub_title">${list[0].category.type}</h2>
				<ul id="first-carousel"
					class="first-and-second-carousel jcarousel-skin-tango">
					<c:forEach items="${list }" var="product">
						<li><a href="${shop}/product_get?id=${product.id}"
							class="product_image"><img src="${shop}/files/${product.pic}" /></a>
							<div class="product_info">
								<h3>
									<a href="#">商品名称：${product.name }</a>
								</h3>
								<small>简单描述：${product.remark}</small>
							</div>
							<div class="price_info">
								<a href="${shop}/sorder_addSorder?product.id=${product.id}"><button>
										<span class="pr_add">添加购物车</span>
									</button></a>
								<button class="price_add" title="" type="button">
									<span class="pr_price">￥${product.price}</span>
								</button>
							</div></li>
					</c:forEach>
				</ul>
			</div>
		</c:forEach>


		<!--产品列表结束  -->

		<!-- 底部栏 -->
		<%@include file="/public/bottom.jspf"%>
		<!--底部结束-->
	</div>
</body>
</html>