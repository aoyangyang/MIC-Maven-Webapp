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
    
    <title>学工组查看考勤统计</title>
	<%@include file="../common/context.jsp" %>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/mic/workView.css"/>
    <script src="${basePath}/laydate/laydate.js" type="text/javascript" charset="utf-8"></script>
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
				<h2 class="ui left floated header">学工组查看考勤统计</h2>
		  		<div class="ui clearing divider"></div>
				<!--统计图-->
				<h4 class="ui horizontal divider header"><i class="bar chart icon"></i>第${classs}大节课</h4>
				<div class="ui stackable three column grid">
				<!-- 饼图 -->
					<c:forEach items="${pancakeList}" var="pancake">
	  					<div class="column">
	  						<div class="ui segment basic vertical t">
								<h5>${pancake.getPanckeName()}</h5>
								<div class="ui center aligned segment vertical basic">
									<div id="${pancake.getId()}" style=" width: 100%;height: 300px;"></div>
								</div>
								<a href="${basePath}/work/fond/${time}/${pancake.getId()}">
									<button class="ui right floated teal button">查看详情</button>	
								</a>
							</div>
	  					</div>
  					</c:forEach>
  					
				</div>
			</div>
		</div>
        <%@include file="../common/food.jsp" %>
        <script>
      	  <c:forEach items="${pancakeList}" var="pancake">
				var chart = AmCharts.makeChart( 
					'${pancake.getId()}', {
				    	"type": "pie",
				 		 "theme": "light",
				 		 "dataProvider":
				 		 [{
				   		 	"country": "到课",
				  		 	 "litres": ${pancake.getAttendance()}
				 		 },{
						    "country": "请假",
						    "litres": ${pancake.getLeave()}
						 },{
						    "country": "旷课",
						    "litres": ${pancake.getAbsence()}
						 }],
						
					    "valueField": "litres",
					  	"titleField": "country",
					  	 "balloon":{
					  	 "fixedPosition":true}
					} );
			</c:forEach>
		</script>
    </body>
</html>
