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
    
    <title>老师查看答题详情</title>
	<%@include file="../common/context.jsp" %>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/mic/sutIndex.css"/>
    <link rel="stylesheet" type="text/css" href="${basePath}/LigthBox/lightbox.css"/>
    
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
				<button class="ui button" style="float: right;" onclick="goBack()">
					返回			
				</button>	
				<h2>老师查看答题详情</h2>
				<div class="ui divider"></div>
				<h5>排序按答题时间排序</h5>
				<div class="myBox">
					<table class="ui celled table">
						<thead>
							<tr>
								<th>
									<font style="vertical-align: inherit;">
										学生姓名
									</font>
								</th>
								<th>
									<font style="vertical-align: inherit;">
										答案
									</font>
								</th>
								<th>
									<font style="vertical-align: inherit;">
										是否正确
									</font>
								</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${detailsList }" var="details">
								<tr>
									<td data-label="Name">
										<font style="vertical-align: inherit;">
											${details.username }
										</font>
									</td>
									<td data-label="Ans">
										<font style="vertical-align: inherit;">
											${details.answer }
										</font>
									</td>
									<td data-label="Correct">
										<font style="vertical-align: inherit;">
											<c:if test="${details.correct == 1}">
												<p style="color: blue;">正确<p>
											</c:if>
											<c:if test="${details.correct != 1}">
												<p style="color: red;">错误<p>
											</c:if>
										</font>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
        <%@include file="../common/food.jsp" %>
    </body>
</html>
