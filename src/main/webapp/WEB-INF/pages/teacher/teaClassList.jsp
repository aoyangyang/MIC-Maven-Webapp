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
    
    <title>教师课程信息</title>
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
				<h2>教师课程信息</h2><span>点击课程ID进入课程操作</span>
				<table class="ui celled table">
					<thead>
						<tr>
							<th style="color: red;">课程ID</th>
							<th>课程名</th>
							<th>班级人数</th>
							<th>开课时间</th>
							<th>上课地点</th>
						</tr>
					</thead>
					<tbody id="tbo">
						<c:forEach items="${classList}" var="classs" >
							<tr>
								<td>
									<a href="${basePath}/teacher/class/${classs.getId() }">
										${classs.getId() }
									</a>
								</td>
								<td>${classs.getCourse_name() }</td>
								<td>${classs.getSize() }</td>
								<td>${classs.getOpen_time() }</td>
								<td>${classs.getAddress() }</td>
							</tr>
						</c:forEach>
					
					</tbody>
					<tfoot>
						<tr>
							<th colspan="5">
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
									 '/teacher/class/'+val[i].id+
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
