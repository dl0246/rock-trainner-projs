<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <base href="<%=basePath%>"/>
    <script type="text/javascript" src="comm/jquery/jquery-2.1.1.js"></script>
    <script type="text/javascript" src="comm/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="comm/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <title>Title</title>
</head>
<body>
	<form action="UserAction">
		<input type="hidden" name="method" value="login">
		<div>
			登录ID：<input type="text" name="userid" value="rock"/>
			<span>${requestScope.info}</span>
		</div>
		<div>
			登录密码：<input type="password" name="password" value="admin"/>
		</div>
		<div>
			<input type="submit" value="【登录】"/>
			<a href="05-register.jsp">没有账号</a>
			<a>忘记密码</a>
		</div>
	</form>
</body>
</html>