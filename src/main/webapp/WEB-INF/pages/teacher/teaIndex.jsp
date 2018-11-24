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
    
    <title>教师首页</title>
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
  
    <body id="box">
        <%@include file="../common/top.jsp" %>
            <!--中间-->
		<div class="main">
			<div class="ui raised very padded segment">
				<h2>教师首页</h2>
				<div class="boxs">
					<div class="ui img">
						<img alt="" src="${basePath}/img/logo.png" class="ui img">
					</div>
					<a href="${basePath }/teacher/classList">
						<input class="ui primary button" value="进入课堂">
					</a>
				</div>
				<div class="boxs">
					<div class="ui img">
						<img alt="" src="${basePath}/img/logo.png" class="ui img">
					</div>
					<a>
						<input class="ui primary button" value="课后交流">
					</a>
				</div>
				<div class="boxs">
					<div class="ui img">
						<img alt="" src="${basePath}/img/logo.png" class="ui img">
					</div>
					<a href="${basePath}/tBCourse">
						<input class="ui primary button" value="新建课程">
					</a>
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
