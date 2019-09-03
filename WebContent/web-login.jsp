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
	<fieldset>
		<legend>欢迎登录</legend>
		<form action="UserAction1">
			<div>
				Userid:<input type="text" name="userid"/>
				<span>${requestScope.info}</span>
			</div>
			<div>
				password:<input type="password" name="password"/>
			</div>
			<div>
				<input type="submit" value="【登录】"/>
			</div>
		</form>
	</fieldset>
</body>
</html>