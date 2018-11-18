<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>教师单门课程信息</title>
	<%@include file="../common/context.jsp" %>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/mic/sutIndex.css"/>
    
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

    </head>
  
    <body id="box">
        <%@include file="../common/top.jsp" %>
        <!--中间-->
		<div class="main">
			<div class="ui raised very padded segment">
				<h2>教师单门课程信息</h2>
				<table class="ui celled table">
					<thead>
						<tr>
							<th style="color: red;">课程ID</th>
							<th>课程名</th>
							<th>开始时间</th>
							<th>结束时间</th>
							<th>上课内容</th>
							<th></th>
							<th></th>
						</tr>
					</thead>
					<tbody id="tbo">
						<c:forEach items="${coureList}" var="coure" >
							<tr>
								<td>${coure.getCourse_id() }</td>
								<td>${coure.getName() }</td>
								<td>${coure.getBegin_time() }</td>
								<td>${coure.getEnd_time() }</td>
								<td>${coure.getIntroduction() }</td>
								<td>
									<button class="ui button inverted red">
										修改
									</button>
								</td>
								<td>
									<button class="ui button inverted blue">
										设置问题
									</button>
								</td>
							</tr>
						</c:forEach>
					
					</tbody>
					<tfoot>
						<tr>
							<th colspan="7">
								<div class="ui right floated pagination menu">
									<c:forEach begin="1" end="${no}" var="i">
										<a class="item" onclick="doIt(${i})">${i}</a> 
									</c:forEach>
								</div>
							</th>
						</tr>
					</tfoot>
				</table>
			</div>
		</div>
		
        <%@include file="../common/food.jsp" %>
        <script type="text/javascript">
        	$('.ui.radio.checkbox')
        		.checkbox()
        	;
        	function doIt(number){
        		$.ajax({
					type:"post",
					url:"${basePath}/getClassList",
					data:{"number":number},
					success:function(data){
						val=eval(data);
						var dHtml = '';
						for(i in val){
							dHtml += '<tr><td>'+
									 '<a href="'+'${basePath}'+
									 '/teacher/classMsg/'+val[i].id+
									 '">'+
									 val[i].id+
									 '</a>'+
									 '</td>'+
									 '<td>'+val[i].course_name+'</td>'+
									 '<td>'+val[i].size+'</td>'+
									 '<td>'+val[i].open_time+'</td>'+
									 '<td>'+val[i].address+'</td></tr>';
						}
						$("#tbo *").remove();
						$("#tbo").html(dHtml);
					}
				});
        	}
        	
        </script>
    </body>
</html>
