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
    <script type="text/javascript">
    	$(function(){
    		$('#userid').on('blur',function(){
    			var xmlhttp;
    			/* 判断当前浏览器是否支持XMLHttpRequest对象 */
    			if (window.XMLHttpRequest)
    			  {// code for IE7+, Firefox, Chrome, Opera, Safari
    			  	xmlhttp=new XMLHttpRequest();
    			  }
    			else
    			  {// code for IE6, IE5
    			 	 xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    			  }
			
				
				xmlhttp.onreadystatechange=function()
				  {
				  if (xmlhttp.readyState==4 && xmlhttp.status==200)
				    {
					  /* 
					  	responseText/服务器端响应回来的内容  
					  	返回了一个String yes | no
					  	需要服务器端响应回来一个json
					  
					  */
				   		$('#info').html(xmlhttp.responseText);
				    }
				  }
				
				
				xmlhttp.open('GET','AjaxAction?userid='+$(this).val(),true);
				xmlhttp.send();
    		});
    	});
    </script>
</head>
<body>
	<fieldset>
		<legend>注册</legend>
		<form action="">
		<div>
			userid:<input type="text" name="userid" id="userid">
			<span id="info"></span>
		</div>
		<div>
			password:<input type="password" name="password">
		</div>
		<div>
			<input type="submit" value="注册">
		</div>
	</form>
	</fieldset>
</body>
</html>