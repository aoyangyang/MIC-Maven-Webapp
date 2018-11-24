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
    
    <title>老师考勤信息</title>
	<%@include file="../common/context.jsp" %>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/mic/details.css"/>
    <script src="${basePath}/js/amcharts/amcharts.js" type="text/javascript" charset="utf-8"></script>
	<script src="${basePath}/js/amcharts/pie.js" type="text/javascript" charset="utf-8"></script>
	<script src="${basePath}/js/amcharts/light.js" type="text/javascript" charset="utf-8"></script>
    
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
			<div class="ui segment raised very padded">
				<!--统计图-->
				
				<div class="ui segment basic vertical t">
					<h2 class="ui left floated header">${pancakeDate.getPanckeName()}</h2>
					<button class="ui button inverted blue" style="float: right;" onclick="goBack()">
						返回
					</button>
		  			<div class="ui clearing divider"></div>
					<div class="ui center aligned segment vertical basic">
						<!--  =================  -->
						<!--       = 统图 =       -->
						<!--  =================  -->
						<c:if test="${pancakeDate.getAttendance()==0
								&&pancakeDate.getLeave()==0
								&&pancakeDate.getAbsence()==0}">
							<h3 class="ui  header">
								次节课未点到或此节课无课
							</h3>
						</c:if>
						<c:if test="${pancakeDate.getAttendance()!=0
								&&pancakeDate.getLeave()!=0
								&&pancakeDate.getAbsence()!=0}">
							<div id="chartdiv" 
								style=" width: 100%;
				 				height: 500px;"
				 				></div>
						</c:if>
					</div>
				</div>
				<!--  ==========  -->
				<!--  = 表格 =  -->
				<!--  ==========  -->
				<h3 class="ui left floated header">旷课</h3>
		  		<div class="ui clearing divider"></div>
				<table class="ui inverted red striped table">
					<thead>
						<tr>
							<th>姓名</th>
							<th>时间</th>
							<th>电话</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${absenceList}" var="absence">
							<tr>
								<td>${absence.getUsername() }</td>
								<td>${absence.getTime() }</td>
								<td>${absence.getPhone() }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<br /><br />
				<h3 class="ui left floated header">请假</h3>
		  		<div class="ui clearing divider"></div>
				<table class="ui striped table">
					<thead>
						<tr>
							<th>姓名</th>
							<th>时间</th>
							<th>电话</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${leaveList}" var="leave">
							<tr>
								<td>${leave.getUsername() }</td>
								<td>${leave.getTime() }</td>
								<td>${leave.getPhone() }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			
		</div>
        <%@include file="../common/food.jsp" %>
        <script>
			var chart = AmCharts.makeChart( 
				"chartdiv", {
			    	"type": "pie",
			 		 "theme": "light",
			 		 "dataProvider":
			 		 [{
			   		 	"country": "到课",
			  		 	 "litres": ${pancakeDate.getAttendance()}
			 		 },{
					    "country": "请假",
					    "litres": ${pancakeDate.getLeave()}
					 },{
					    "country": "旷课",
					    "litres": ${pancakeDate.getAbsence()}
					 }],
					"fontSize":20,
				    "valueField": "litres",
				  	"titleField": "country",
				  	 "balloon":{
				  	 "fixedPosition":true}
				} );
		</script>
    </body>
</html>
