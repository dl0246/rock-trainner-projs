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
    		$('#btn').on('click',function(){
    			var xhr=new XMLHttpRequest();
    			xhr.onreadystatechange=function(){
    				if(xhr.readyState==4 && xhr.status==200){
    					$('#allnews-table tbody').empty();
    					var news=xhr.responseText;//news 是一个   String
    					var json=JSON.parse(news);
    					$.each(json,function(index,n){
    						var newsidTD=$('<td></td>').append(n.newsid);
    						var titleTD=$('<td></td>').append(n.title);
    						var typeidTD=$('<td></td>').append(n.typeid);
    						var tr=$('<tr></tr>').append(newsidTD).append(titleTD).append(typeidTD);
    						$('#allnews-table tbody').append(tr);
    					});
    				}
    			}
    			
    			xhr.open("GET","NewsAJAXAction","true");
    			xhr.send();
    		});
    		
    		$('#btn-addnews').click(function(){
    			location.href="add.html";
    		});
    	});
    </script>
</head>
<body>
	<a href="ResponseAction">ResponseAction</a><br/>
	<!-- <a href="ResponseAction">ResponseAction</a><br/> -->
	
	
	<div class="container">
		<div class="row">
			<fieldset>
			<legend><button class="btn btn-success" id="btn">查看所有新闻</button>
				<button class="btn btn-success"  id="btn-addnews">新闻发布</button>
			</legend>
			<table class='table' id="allnews-table">
				<thead>
					<tr>
						<th>新闻编号</th>
						<th>新闻标题</th>
						<th>新闻类型</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>162</td>
						<td>asdfasfasdfasdfdas</td>
						<td>dsafasfadsfasf</td>
					</tr>
					<tr>
						<td>88888</td>
						<td>asdfasfasdfasdfdas</td>
						<td>dsafasfadsfasf</td>
					</tr>
					<tr>
						<td>88888</td>
						<td>asdfasfasdfasdfdas</td>
						<td>dsafasfadsfasf</td>
					</tr>
					<tr>
						<td>88888</td>
						<td>asdfasfasdfasdfdas</td>
						<td>dsafasfadsfasf</td>
					</tr>
					<tr>
						<td>88888</td>
						<td>asdfasfasdfasdfdas</td>
						<td>dsafasfadsfasf</td>
					</tr>
				</tbody>
			</table>
			</fieldset>
		</div>
		<hr/>
		<div class="row">其他内容</div>
	</div>
</body>
</html>