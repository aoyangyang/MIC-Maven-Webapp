<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>辅导员、学工组详情</title>
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
					<h2 class="ui left floated header">计算机一班</h2>
		  			<div class="ui clearing divider"></div>
					<div class="ui center aligned segment vertical basic">
						<!--  =================  -->
						<!--       = 统图 =       -->
						<!--  =================  -->
						<div id="chartdiv" 
							style=" width: 100%;
			 				height: 500px;"
			 				></div>
						<script>
							var chart = AmCharts.makeChart( 
								"chartdiv", {
							    	"type": "pie",
							 		 "theme": "light",
							 		 "dataProvider":
							 		 [{
							   		 	"country": "到课",
							  		 	 "litres": 30
							 		 },{
									    "country": "请假",
									    "litres": 5
									 },{
									    "country": "旷课",
									    "litres": 2
									 }],
									"fontSize":20,
								    "valueField": "litres",
								  	"titleField": "country",
								  	 "balloon":{
								  	 "fixedPosition":true}
								} );
						</script>
						<!--  ==========  -->
						<!--  = 统计结束 =  -->
						<!--  ==========  -->
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
							<th>Called</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>约翰·莉丽亚</td>
							<td>2013年9月14日</td>
							<td>jhlilk22@yahoo.com</td>
							<td>否</td>
						</tr>
						<tr>
							<td>杰米·哈灵顿</td>
							<td>2014年1月11日</td>
							<td>jamieharingonton@yahoo.com</td>
							<td>是</td>
						</tr>
					</tbody>
				</table>
				<br /><br />
				<h3 class="ui left floated header">请假</h3>
		  		<div class="ui clearing divider"></div>
				<table class="ui striped table">
					<thead>
						<tr>
							<th>Name</th>
							<th>Date Joined</th>
							<th>E-mail</th>
							<th>Called</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>约翰·莉丽亚</td>
							<td>2013年9月14日</td>
							<td>jhlilk22@yahoo.com</td>
							<td>否</td>
						</tr>
						<tr>
							<td>杰米·哈灵顿</td>
							<td>2014年1月11日</td>
							<td>jamieharingonton@yahoo.com</td>
							<td>是</td>
						</tr>
					</tbody>
				</table>
			</div>
			
		</div>
        <%@include file="../common/food.jsp" %>
    </body>
</html>
