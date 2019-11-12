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
				<h2>教师首页</h2>
				<div class="ui divider"></div>
				<div class="myBox">
					<img class="ui  rounded image" src="${basePath}/img/stu/stu1.jpg"></img>
					<p>
						<a href="${basePath }/teacher/classList">
							<button class="ui primary fluid   button" >进入课堂</button>
						</a>
					</p>
				</div>
				<div class="myBox">
					<img class="ui  rounded image" src="${basePath}/img/stu/stu2.jpg"></img>
					<p>
						<a href="">
							<button class="ui primary fluid   button" >课后交流</button>
						</a>
					</p>
				</div>
				<div class="myBox">
					<img class="ui  rounded image" src="${basePath}/img/tea/tea1.jpg"></img>
					<p>
						<a href="${basePath}/tBCourse">
							<button class="ui primary fluid   button" >新建课程</button>
						</a>
					</p>
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
