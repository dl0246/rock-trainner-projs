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
    <title>Title</title>
    <!-- base:用于设置当前页面的基准目录 -->
    <base href="<%=basePath%>">
</head>
<body>
	<a href="bb/bb.jsp">bb.jsp</a>
	<hr/>
	<img src="http://localhost:8080/ssss/images/img.jpg">
<hr/>
<hr/>
<hr/>
<hr/>


	aa.jsp
	<hr/>
	<a href="../bb/bb.jsp">去bb家</a>
	<!-- @WebServlet("/PathAction") -->
	<a href="PathAction">PageAction</a>
	
	
	
</body>
</html>