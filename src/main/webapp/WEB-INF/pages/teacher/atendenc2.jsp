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
		<script src="${basePath}/js/qrcode.min.js" type="text/javascript" charset="utf-8"></script>
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
						<div id="qrcode" style="width:500px; margin: 0 auto;"></div>
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
			$('.ui.checkbox').checkbox();
		
			var temp = 0;
			/*开始点到*/
			play = function() {
				if(temp == 1){
					alert("点到已经开始");
					return 0;
				}
				var state = $('#cBox').is(":checked") ? 1:0;
				temp = 1;
				var r = confirm("是否开始点到？");
				if(r){
					$.ajax({
						type: "post",
						url: "${basePath}/teacher/atendnc/play/qc",
						data: {
							"noteId": ${noteId}
						},
						success: function(data) {
							$("#lodingMsg").remove();
							$("#tabe").css({"display":"block"});
							getMsg();
							
							/* 展示二维码 */
							var qrcode = new QRCode(document.getElementById("qrcode"),{
						    	width: 500,
		    					height: 500
						    });
						    setInterval("doit();",1);
						    var timeTemp = parseInt(data);
							var datess;
							
						    doit = function () {
						    	datess = new Date();
						        qrcode.makeCode("test"+datess.getTime()*timeTemp);
						    }
						    
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
				    	post("${basePath}/teacher/atendnc/stop",{"noteId":${noteId}});
			    	}else{
			    		alert("请先开始点到")
			    	}
		    	}
		    };
		</script>
		<c:if test="${teaTemp ==1 }">
			<script type="text/javascript">
				//如果是已经开始点到的那么久展示点到
				$("#lodingMsg").remove();
				$("#tabe").css({"display":"block"});
				temp = 1;
				getMsg();
				
				/* 二维码 */
				var qrcode = new QRCode(document.getElementById("qrcode"),{
			    	width: 500,
   					height: 500
			    });
			    setInterval("doit();",1);
			    var datess;
			    
				var timeTemp = parseInt('${timeKeys}');
			    doit = function () {
			    	datess = new Date();
			        qrcode.makeCode("test"+datess.getTime()*timeTemp);
			    }
			</script>
		</c:if>
	</body>
</html>