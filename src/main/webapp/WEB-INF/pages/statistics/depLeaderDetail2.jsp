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
    
    <title>院领导查看考勤统计</title>
	<%@include file="../common/context.jsp" %>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/mic/depLeaderDetail.css"/>
    <script src="../laydate/laydate.js" type="text/javascript" charset="utf-8"></script>
	<script src="${basePath}/js/amcharts/amcharts.js" type="text/javascript" charset="utf-8"></script>
	<script src="${basePath}/js/amcharts/serial.js" type="text/javascript" charset="utf-8"></script>
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
				<h2 class="ui left floated header">院领导查看考勤统计</h2>
		  		<div class="ui clearing divider"></div>
		  		<input v-model="test" type="" name="" id="" value="sds " />
		  		<input v-model="test1" type="" name="" id="" value="1" />
				<!--统计图-->
				<div class="ui segment basic vertical t">
					<h3>理工学部</h3>
					<div class="ui center aligned segment basic">
						<!--  =================  -->
						<!--       = 统图 =       -->
						<!--  =================  -->
						<div id="chartdiv" 
							style=" width: 100%;
			 				height: 300px;"
			 				></div>
						<script>
							var vm = new Vue({
								el:"#box",
								data:{
									test:'',
									test1:0
								},
								methods:{
								},
								watch:{
								}
							});
							function show(){
								var chart = AmCharts.makeChart("chartdiv", {
								    "theme": "light",
								    "type": "serial",
									"startDuration": 0,
								    "dataProvider":
								    [{
								        "country": vm.test,
								        "visits": vm.test1,
								        "color": "#FF0F00"
								    },{
								        "country": "计算机二班",
								        "visits": 3,
								        "color": "#FF6600"
								    },{
								        "country": "计算机二班",
								        "visits": 3,
								        "color": "#FF6600"
								    },{
								        "country": "计算机二班",
								        "visits": 3,
								        "color": "#FF6600"
								    },{
								        "country": "计算机三班",
								        "visits": 1,
								        "color": "#FF9E01"
								    }],
								    "valueAxes": [{
								        "position": "left",
								        "title": "旷课人数"
								    }],
								    "fontSize":18,
								    "graphs": [{
								        "balloonText": "[[category]]: <b>[[value]]</b>",
								        "fillColorsField": "color",
								        "fillAlphas": 1,
								        "lineAlpha": 0.1,
								        "type": "column",
								        "valueField": "visits"
								    }],
								    "depth3D": 20,
									"angle": 30,
								    "chartCursor": {
								        "categoryBalloonEnabled": false,
								        "cursorAlpha": 1,
								        "zoomable": false
								    },
								    "categoryField": "country",
								    "categoryAxis": {
								        "gridPosition": "start",
								        "labelRotation": 90
								    },
								    "export": {
								    	"enabled": true
								     }
								});
							}
						</script>
						<!--  ==========  -->
						<!--  = 统计结束 =  -->
						<!--  ==========  -->
					</div>
				</div>
				
				<div class="ui segment basic vertical t">
					<div class="ui center aligned segment basic">
						<!--  =================  -->
						<!--       = 统图 =       -->
						<!--  =================  -->
						<div id="chartdiv1" 
							style=" width: 100%;
			 				height: 300px;"
			 				></div>
						<script>
							function show1(){
								var chart = AmCharts.makeChart("chartdiv1", {
								    "theme": "light",
								    "type": "serial",
									"startDuration": 0,
								    "dataProvider":
								    [{
								        "country": "计算机一班",
								        "visits": 5,
								        "color": "#FF0F00"
								    },{
								        "country": vm.test,
								        "visits": vm.test1,
								        "color": "#FF6600"
								    },{
								        "country": "计算机二班",
								        "visits": 3,
								        "color": "#FF6600"
								    },{
								        "country": "计算机二班",
								        "visits": 3,
								        "color": "#FF6600"
								    },{
								        "country": "计算机三班",
								        "visits": 1,
								        "color": "#FF9E01"
								    }],
								    "valueAxes": [{
								        "position": "left",
								        "title": "请假人数"
								    }],
								    "fontSize":18,
								    "graphs": [{
								        "balloonText": "[[category]]: <b>[[value]]</b>",
								        "fillColorsField": "color",
								        "fillAlphas": 1,
								        "lineAlpha": 0.1,
								        "type": "column",
								        "valueField": "visits"
								    }],
								    "depth3D": 20,
									"angle": 30,
								    "chartCursor": {
								        "categoryBalloonEnabled": false,
								        "cursorAlpha": 1,
								        "zoomable": false
								    },
								    "categoryField": "country",
								    "categoryAxis": {
								        "gridPosition": "start",
								        "labelRotation": 90
								    },
								    "export": {
								    	"enabled": true
								     }
								});
							}
						</script>
						<!--  ==========  -->
						<!--  = 统计结束 =  -->
						<!--  ==========  -->
					</div>
				</div>
			</div>
		</div> 
        <%@include file="../common/food.jsp" %>
        	<script type="text/javascript">
		var chart = AmCharts.makeChart("chartdiv", {
								    "theme": "light",
								    "type": "serial",
									"startDuration": 2,
								    "dataProvider":
								    [{
								        "country": vm.test,
								        "visits": vm.test1,
								        "color": "#FF0F00"
								    },{
								        "country": "计算机二班",
								        "visits": 3,
								        "color": "#FF6600"
								    },{
								        "country": "计算机二班",
								        "visits": 3,
								        "color": "#FF6600"
								    },{
								        "country": "计算机二班",
								        "visits": 3,
								        "color": "#FF6600"
								    },{
								        "country": "计算机三班",
								        "visits": 1,
								        "color": "#FF9E01"
								    }],
								    "valueAxes": [{
								        "position": "left",
								        "title": "旷课人数"
								    }],
								    "fontSize":18,
								    "graphs": [{
								        "balloonText": "[[category]]: <b>[[value]]</b>",
								        "fillColorsField": "color",
								        "fillAlphas": 1,
								        "lineAlpha": 0.1,
								        "type": "column",
								        "valueField": "visits"
								    }],
								    "depth3D": 20,
									"angle": 30,
								    "chartCursor": {
								        "categoryBalloonEnabled": false,
								        "cursorAlpha": 1,
								        "zoomable": false
								    },
								    "categoryField": "country",
								    "categoryAxis": {
								        "gridPosition": "start",
								        "labelRotation": 90
								    },
								    "export": {
								    	"enabled": true
								     }
								});
		var chart = AmCharts.makeChart("chartdiv1", {
								    "theme": "light",
								    "type": "serial",
									"startDuration": 2,
								    "dataProvider":
								    [{
								        "country": "计算机一班",
								        "visits": 5,
								        "color": "#FF0F00"
								    },{
								        "country": vm.test,
								        "visits": vm.test1,
								        "color": "#FF6600"
								    },{
								        "country": "计算机二班",
								        "visits": 3,
								        "color": "#FF6600"
								    },{
								        "country": "计算机二班",
								        "visits": 3,
								        "color": "#FF6600"
								    },{
								        "country": "计算机三班",
								        "visits": 1,
								        "color": "#FF9E01"
								    }],
								    "valueAxes": [{
								        "position": "left",
								        "title": "请假人数"
								    }],
								    "fontSize":18,
								    "graphs": [{
								        "balloonText": "[[category]]: <b>[[value]]</b>",
								        "fillColorsField": "color",
								        "fillAlphas": 1,
								        "lineAlpha": 0.1,
								        "type": "column",
								        "valueField": "visits"
								    }],
								    "depth3D": 20,
									"angle": 30,
								    "chartCursor": {
								        "categoryBalloonEnabled": false,
								        "cursorAlpha": 1,
								        "zoomable": false
								    },
								    "categoryField": "country",
								    "categoryAxis": {
								        "gridPosition": "start",
								        "labelRotation": 90
								    },
								    "export": {
								    	"enabled": true
								     }
								});
		window.setInterval(show,2000);
		window.setInterval(show1,2000);
		
		function showTest(){
			vm.test1 = parseInt(vm.test1)+parseInt(1);
		}
		window.setInterval(showTest,3000);
	</script>
    </body>
</html>
