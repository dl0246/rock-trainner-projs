<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    
    <script type="text/javascript" src="comm/jquery/jquery-2.1.1.js"></script>
    <script type="text/javascript" src="comm/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="comm/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    
    <style type="text/css">
    	 h1#title{
            color: #e38d13;
        }
    </style>
    <script type="text/javascript">
    	$(function(){
    		$('#slsall').on('click',function(){
    			var v=$(this).prop('checked');
    			$('.chkelement').prop('checked',function(){
    				return v;
    			});
    		});
    		
    		$('#news-deletebatch').on('click',function(){
    			var bs=$('.chkelement:checked');
    			if(bs.length<=0){
    				alert("请选择被删除的新闻后在单击这个按钮");
    				return false;
    			}
    			var ids='';
    			for(var i=0;i<bs.length;i++){
    				ids=ids+$(bs[i]).val()+',';
    			}
    			ids=ids.substr(0,ids.length-1);
    			location.href='NewsAction?method=delBatch&ids='+ids;
    			
    		});
    		
    		
    		
    		$('#news-add').on('mouseenter',function(){
    			$(this).attr('title','单击我发布新闻');
    		});
    		$('#news-add').on('click',function(){
    			reset_modal_add_form('#modal-add form');
    			$("#modal-add").modal({
    				backdrop : "static"
    			});
    		});
    		
    		function reset_modal_add_form(selector){
    			$(selector)[0].reset();
    			$(selector).find("*").removeClass("has-error has-success");
    			$(selector).find(".help-block").text("");
    		}
    		
    		$('#news-deletebatch').on('mouseenter',function(){
    			$(this).attr('title','单击我完成批量删除新闻');
    		});
    		
    	});
	    	function doDelete(newsid){
	    		if(confirm('确定要删除['+newsid+']吗？')){
					location.href='NewsAction?method=doDelete&newsid='+newsid;
					layer.msg('信息删除成功');
	    		}
	    	}
    </script>
</head>
<body>
<!-- 发布新闻的模态框 -->
<div class="modal fade" id="modal-add" tabindex="-1" role="dialog"
     aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"
                        aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">修改员工信息</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="formEmpAdd">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">员工编号</label>
                        <div class="col-sm-10">
                            <input type="text" name="empno" class="form-control"
                                   id="empno_add_input" placeholder="empno"> <span
                                class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">员工姓名</label>
                        <div class="col-sm-10">
                            <input type="text" name="ename" class="form-control"
                                   id="ename_add_input" placeholder="ename"> <span
                                class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">岗位名称</label>
                        <div class="col-sm-10">
                            <input type="text" name="job" class="form-control"
                                   id="job_add_input" placeholder="软件工程师"> <span
                                class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">直接领导</label>
                        <div class="col-sm-4">
                            <!-- <input type="text" name="mgr" class="form-control"
                                id="mgr_add_input" placeholder="7788"> <span
                                class="help-block"></span> -->
                            <select class="form-control" name="dId" id="mid"></select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">基本工资</label>
                        <div class="col-sm-10">
                            <input type="text" name="sal" class="form-control"
                                   id="sal_add_input" placeholder="10000"> <span
                                class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">月度奖金</label>
                        <div class="col-sm-10">
                            <input type="text" name="comm" class="form-control"
                                   id="comm_add_input" placeholder="10000"> <span
                                class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">个人头像</label>
                        <div class="col-sm-4">
                            <div id="imgDiv">
                                <img src="images/base.jpg" class="img-circle" alt="100×100"
                                     style="width: 80px;height:80px;cursor: pointer"
                                     id="selfImg"
                                />

                            </div>
                            <input type="file" id="file" name="file" style="visibility: hidden;">
                            <input type="hidden" id="myimg" name="myimg" value=""/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">deptName</label>
                        <div class="col-sm-4">
                            <!-- 部门提交部门id即可 -->
                            <select class="form-control" name="dId" id="did"></select>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">【关闭】</button>
                <button type="button" class="btn btn-primary" id="btn-addemp-empAddModal">【保存】</button>
            </div>
        </div>
    </div>
</div>
	<div class="container">
		  <!-- 标题 -->
        <div class="row">
            <div class="col-md-12">
                <h1 id="title">新闻-CURD</h1>
            </div>
        </div>
		<div class="row">
		<fieldset>
		<legend>所有新闻如下 
			<button class="btn btn-success" id="news-add">
				<span class="glyphicon glyphicon-tree-deciduous"></span>
			</button>
			
			<button class="btn btn-danger" id="news-deletebatch">
				<span class="glyphicon glyphicon-remove"></span>
			</button>
		</legend>
		<table class="table table-hover table-striped table-bordered">
			<thead>
					<tr>
						<th>#</th>
						<th>
							<input type="checkbox" id="slsall">
						</th>
						<th>新闻编号</th>
						<th>新闻标题</th>
						<th>新闻类型</th>
						<th>发布时间</th>
						<th>发布人</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="n" items="${requestScope.pageinfo.pageList }" varStatus="sts">
						<tr>
							<td>
								${sts.index+1 }
							</td>
							<td><input type="checkbox" value="${n.newsid }" class="chkelement"></td>
							<td>${n.newsid }</td>
							<td>${n.title }</td>
							<td>${n.typename }</td>
							<td>${n.newsdate }</td>
							<td>${n.userid }</td>
							<td>
								<!-- 
									<a onclick="doDelete();">删除</a>
									<a onclick="queryById();">修改</a> 
								-->
								<button class="btn btn-danger btn-sm" onclick="doDelete(${n.newsid });">
									<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
								</button>
								<button class="btn btn-info btn-sm" onclick="doUpdate(${n.newsid });">
									<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
								</button>
							</td>
						</tr>
					</c:forEach>
					<tr>
						<td colspan="8">
							共有【${requestScope.pageinfo.rows }】条数据，
							共有【${requestScope.pageinfo.maxpage }】页，
							当前显示【${requestScope.pageinfo.cpage }/${requestScope.pageinfo.maxpage }】页
							
							<a href="PageAction?cpage=1">首页</a>
							<a href="PageAction?cpage=${requestScope.pageinfo.cpage-1 }">&lt;&lt;</a>
							<a href="PageAction?cpage=${requestScope.pageinfo.cpage+1 }">&gt;&gt;</a>
							<a href="PageAction?cpage=${requestScope.pageinfo.maxpage }">尾页</a>
						</td>
					</tr>
				</tbody>
		</table>
	</fieldset>
		
		</div>
	</div>
	
</body>
</html>