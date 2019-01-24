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

		<title>教师点到</title>
		<%@include file="../common/context.jsp" %>
		<link rel="stylesheet" type="text/css" href="${basePath}/css/mic/sutIndex.css" />
		<link rel="stylesheet" type="text/css" href="${basePath}/css/mic/atendenc.css"/>
		<script src="${basePath}/js/amcharts/amcharts.js" type="text/javascript" charset="utf-8"></script>
		<script src="${basePath}/js/amcharts/serial.js" type="text/javascript" charset="utf-8"></script>
		<script src="${basePath}/js/amcharts/light.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript" src="${basePath}/js/cp.js"></script>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		.but{
			height: 40px;
			width: 20%;
			background-color: red;
			border-radius: 40px;
		}	
		.ui.img{
			max-width: 80%;
		}
	</style>
	
	</head>

	<body id="box">
		<%@include file="../common/top.jsp" %>
		<!--中间-->
		<div class="main">
			<div class="ui raised very padded segment">
				<h2>教师点到</h2>
				<div class="ui divider"></div>
				<div class="ui segment basic  center aligned">
					<button class="ui massive circular facebook icon button" onclick="play()" >
					  	<i class="play icon"></i>&nbsp;开始点到 
					</button>
					<button class="ui massive circular red facebook icon button" onclick="stop()" >
					  	<i class="stop icon"></i>&nbsp;结束点到 
					</button>
					<div class="inline field">
					    <div class="ui toggle checkbox"><br>
					    <input type="checkbox" tabindex="0" class="hidden" id="cBox"  >
					    <label>开启人脸识别</label>
						</div>
					</div>
				</div>
				<div class="ui segment" id="lodingMsg">
					<div class="ui active dimmer">
						<div class="ui text loader">
							<h2>未开始点到</h2>
							<h2>暂无数据</h2>
							<h2>如需点到请点击开始点到</h2>
						</div>
					</div>
					<div class="ui img">
						<img class="ui fluid image" src="img/short-paragraph.png">
					</div>
					<div class="ui img">
						<img class="ui fluid image" src="img/short-paragraph.png">
					</div>
					<div class="ui img">
						<img class="ui fluid image" src="img/short-paragraph.png">
					</div>
					<div class="ui img">
						<img class="ui fluid image" src="img/short-paragraph.png">
					</div>
					
				</div>
				<!-- 统计表 -->
				<div class="ui segment basic vertical t" id="tabe" style="display: none">
					<div class="ui center aligned segment basic" id="msgTable">
						<div id="chartdiv1" style=" width: 100%;height: 300px;">
						</div>
					</div>
				</div>
				<!-- 统计表 -->
			</div>
		</div>
		<%@include file="../common/food.jsp" %>
		<script type="text/javascript">
		</script>
	</body>
	<script type="text/javascript">
		$('.ui.checkbox').checkbox();
		/* 得到GPS信号 */
		var mylat = 0;
		var mylong = 0;
		var Gtemp = 0;
		getGps = function(){
			x = navigator.geolocation;
			x.getCurrentPosition(success,failure,{
				enableHighAccuracy:true,
		    	timeout:5000,
		    	maximumAge:0
			});
			function success(position){
				mylat = position.coords.latitude;
				mylong = position.coords.longitude;
				Gtemp = position.coords.accuracy;
			}
			function failure(err){
				alert( err.code );
				alert("请打开定位功能！！");
			}
		};

	
		var temp = 0;
		/*开始点到*/
		play = function() {
			var state = $('#cBox').is(":checked") ? 1:0;
			getGps();
			temp = 1;
			var r = confirm("是否开始点到？");
			if(r){
				$.ajax({
					type: "post",
					url: "${basePath}/teacher/atendnc/play",
					data: {
						"noteId": ${noteId},
						"mylat":mylat,
						"mylong":mylong,
						"temp":Gtemp,
						"state":state
						
					},
					success: function(data) {
						$("#lodingMsg").remove();
						$("#tabe").css({"display":"block"});
						getMsg();
						
					}
				});
			}
		};
		getMsg = function(){
			getMsgDo();
			setInterval("getMsgDo()", 5000);
		}
		
		var tempI = 1;
		getMsgDo = function(){
			var arr=new Array();
			$.ajax({
				type: "post",
				url:"${basePath}/teacher/atendnc/getMsg",
				data:{},
				success:function(date){
					var val = eval(date);
				
					var arr=new Array();
					arr[0]=val[0];
					arr[1]=val[1];
					arr[2]=val[2];
					
					//$("#msgTable").html("");
					//$("#msgTable").html('<div id="chartdiv'+templ+'" style=" width: 100%;height: 300px;">11111</div>');
					var ids = "chartdiv"+tempI;
					show(arr,ids);
					//tempI++;
				}
			});
		}
		
		
		/*结束点到*/
	   stop = function(){
	    	var r = confirm("是否结束点到？");
	    	if(r){
		    	if(temp){
			    	post("${basePath}/teacher/atendnc",{"noteId":${noteId}});
		    	}else{
		    		alert("请先开始点到")
		    	}
	    	}
	    };
	</script>
</html>