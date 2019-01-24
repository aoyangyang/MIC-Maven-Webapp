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
    
    <title>学生选课</title>
	<%@include file="../common/context.jsp" %>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/mic/select1.css"/>
    <script src="${basePath}/js/layDate/laydate/laydate.js" type="text/javascript" charset="utf-8"></script>
    
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
            <form class="ui form" action="${basePath}/student/selectClassDo" method="post">
                <h1 class="ui center aligned dividing header" align="center">学生选课</h1>
                <div class="field">
                    <label>学生姓名</label>
                    <div class="ui fluid left icon input">
                        <input name="sname" type="text"  value="${studentName }" readonly="readonly">
                    </div>
                </div>
                <div class="field">
                    <label>课程ID</label>
                    <div class="ui fluid left icon input">
                        <input name="c_id" type="text"  placeholder="请输入课程ID" value="">
                    </div>
                </div>
                <div class="B">
                    <button class="ui teal button"><i class="ui sign in icon"></i>提交</button>
                </div>
				<br />
            </form>
        </div>
    </div>
        <%@include file="../common/food.jsp" %>
    </body>
</html>
