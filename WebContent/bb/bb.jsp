<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
	<script type="text/javascript" src="${pageContext.request.contextPath}/comm/jquery/jquery.js"></script>    
</head>
<body>


${pageContext.request.contextPath}



	<!-- 
		原因：
		①、这里采用了相对路径
		②、因为cc.jsp和bb.jsp处于同一路径下，所以ok
	 -->
	<a href="${pageContext.request.contextPath}/bb/cc.jsp">跳转到cc家</a>
	<hr/>
	<img src="../images/img.jpg">
</body>
</html>