<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<%@ include file="/public/head.jspf" %>
</head>
<body>
	ok!<br>
	<c:forEach items="${sessionScope.categoryList }" var="category">  
        ${category.id } | ${category.type } | ${category.hot } <br/>  
    </c:forEach><br>
    <a href="${shop}/category_main_aindex">访问aindex</a>
</body>
</html>