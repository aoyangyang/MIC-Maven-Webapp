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
    
    <title>老师建立课程</title>
	<%@include file="../common/context.jsp" %>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/mic/tBCourse.css"/>
    <script src="${basePath}/laydate/laydate.js" type="text/javascript" charset="utf-8"></script>
    
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
            <form class="ui form" action="${basePath}/tBCourseWeb" method="post">
               <h1 class="ui center aligned dividing header">老师建立课程</h1>
                <div class="field">
                    <label>教师姓名</label>
                    <div class="ui fluid left icon input">
						<i class="ui icon user"></i>
                        <input name="teacherName" type="text" readonly="readonly" value="${teacherName}">
                    </div>
                </div>
                <div class="field">
                    <label>课程名</label>
                    <div class="ui fluid left icon input">
						<i class="ui icon list"></i>
                        <input name="className" type="text"  placeholder="请输入课程名" value="">
                    </div>
                </div>
                <div class="field">
                    <label>上课人数</label>
                    <div class="ui fluid left icon input">
                        <i class="ui icon phone"></i>
                        <input name="classNum" type="text"  placeholder="请输入上课人数" value="">
                    </div>
                </div>
                <div class="field">
                    <label>开课时间</label>
                    <div class="ui fluid left icon input">
						<i class="calendar icon"></i>
                        <input name="classTime" type="text"  value="" id="start1">
                    </div>
                </div>
				<div class="field">
					<label>上课地点</label>
					<div class="ui fluid left icon input">
						<i class="ui icon marker"></i>
						<input name="classAddress" type="text"  placeholder="请输入上课地点" value="">
					</div>
				</div>
                <div class="B">
                	<a href="${basePath}/teacher/eClass"><button class="ui teal button"><i class="ui sign in icon"></i>提交</button></a>
                </div>
                <br />
            </form>
        </div>
    </div>
        <%@include file="../common/food.jsp" %>
        <script type="text/javascript">
            laydate.render({
                elem: '#start1',
                value:new Date()
            });
        </script>
    </body>
</html>
