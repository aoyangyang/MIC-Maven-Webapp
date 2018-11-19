<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加班级</title>
	<%@include file="../common/context.jsp" %>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/mic/instructorAdd.css"/>
    
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		.ui.raised.very.padded.segment{
			text-align: center;
			font-size: 14px;
		}
		
	</style>
	
    </head>
  
    <body id="box">
        <%@include file="../common/top.jsp" %>
            <!--中间-->
		<div class="main">
			<div class="ui raised very padded segment">
				<div class="ui segment">
					<a href="${basePath}/studentAdd">学生注册</a>
				</div>
				<div class="ui segment">
					<a href="${basePath}/LeaderWorkAdd">学工组注册</a>
				</div>
				<div class="ui segment">
					<a href="${basePath}/LeaderDepAdd">院领导注册</a>
				</div>
				<div class="ui segment">
					<a href="${basePath}/insAdd">辅导员注册</a>
				</div>
				<div class="ui segment">
					<a href="${basePath}/add/teacherRegister">老师注册</a>
				</div>
			</div>
		</div>
        <%@include file="../common/food.jsp" %>
        <script type="text/javascript">
			$('.ui.dropdown').dropdown();
		</script>
    </body>
</html>
