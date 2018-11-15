<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>500错误页面</title>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/mic/addSchool.css"/>
    <link rel="shortcut icon" href="img/logo.ico" type="image/x-icon"/>
	<link rel="stylesheet" type="text/css" href="${basePath}/css/common/common.css"/>
	<link rel="stylesheet" type="text/css" href="${basePath}/css/semantic.css" />
	<link rel="stylesheet" type="text/css" href="${basePath}/css/animate.css" />
	<script type="text/javascript" src="${basePath}/js/semantic.js"></script>
	<script type="text/javascript" src="${basePath}/js/vue1.js"></script>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
	.ui.segment.very.padded.raised{
		min-height: 300px;
	}
	</style>
  </head>
  
  <body id="box">
    	<div class="top">
			<!--头部-->
			<div class="ui segment fixed menu stackable">
				<div class="top-main">
					<!--logo-->
					<div class="ui image logo">
						<img src="${basePath}/img/logo.png"/>
					</div>
				</div>
			</div>
		</div>
		<!--中间-->
		<div class="main">
			<div class="ui segment very padded raised">
				<h2 class="ui left floated header">错误页面</h2>
		  		<div class="ui clearing divider"></div>
		  		<h3 style="color: red;">错误信息：${errorMessage}&nbsp;{{number}}秒后自动返回</h3>
		  		<br><br><br><br>
		  		<a><button class="ui right floated button" onclick="goBack()">点击返回首页</button></a>
			</div>
		</div>
		<script type="text/javascript">
			function goBack(){
				window.location.href="Login";
			}
			
			var vm = new Vue({
				el:"#box",
				data:{
					number:5
				},
				created:function(){
					setInterval(this.timer, 1000);
				},
				methods:{
					timer:function(){
						this.number = this.number-1;
					}
				},
				watch:{
				}
			});
			
			setTimeout('goBack()',5000);
		</script>
  </body>
</html>
