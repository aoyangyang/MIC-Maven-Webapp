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
    
    <title>学生课堂</title>
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
  <style>
  	.myBox{
  		width: 100%;
  	}
  	.myBox img{
  		margin-bottom: 5px;
  	}
  	.myBox p{
  		margin-bottom: 10%;
  	}
  </style>
    <body id="box">
        <%@include file="../common/top.jsp" %>
            <!--中间-->
		<div class="main">
			<div class="ui raised very padded segment">
				<h2>学生课堂</h2>
				<div class="ui divider"></div>
				<div class="myBox">
				<span>点击课程ID进入课程操作</span>
				<table class="ui celled table">
					<thead>
						<tr>
							<th style="color: red;">课程ID</th>
							<th>课程名</th>
							<th>教师姓名</th>
							<th>上课地点</th>
						</tr>
					</thead>
					<tbody id="tbo">
						<c:forEach items="${couList}" var="classs" >
							<tr>
								<td>
									<a href="${basePath}/student/class/${classs.id }">
										${classs.id }
									</a>
								</td>
								<td>${classs.course_name }</td>
								<td>${classs.teacherName }</td>
								<td>${classs.address }</td>
							</tr>
						</c:forEach>
					
					</tbody>
					<tfoot>
						<tr>
							<th colspan="5">
								<div class="ui right floated pagination menu">
									<c:forEach begin="1" end="${pageNub}" var="i">
										<a class="item" onclick="doIt(${i})">${i}</a> 
									</c:forEach>
								</div>
							</th>
						</tr>
					</tfoot>
				</table>
				</div>
				
			</div>
		</div>
        <%@include file="../common/food.jsp" %>
        <script type="text/javascript">
			$('.ui.radio.checkbox')
			  .checkbox()
			;
			
		</script>
    </body>
</html>
