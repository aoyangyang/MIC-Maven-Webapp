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
    <link rel="stylesheet" type="text/css" href="${basePath}/css/mic/select2.css"/>
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
            <form class="ui form" action="${basePath}/select2" method="post">
                <h1 class="ui center aligned dividing header">课程信息</h1>
                <div class="field">
                    <label>课程名</label>
                    <div class="ui fluid left icon input">
                        <input name="Cname" type="text"  value="${Cname}" readonly="readonly">
                    </div>
                </div>
                <div class="field">
                    <label>教师名</label>
                    <div class="ui fluid left icon input">
                        <input name="Tname" type="text"  readonly="readonly" value="${Tname}">
                    </div>
                </div>
                <div class="B">
                	<button class="ui teal button"><i class="ui checkmark box icon"></i>确定</button>
                </div>
                <br />
            </form>
        </div>
    </div>
        <%@include file="../common/food.jsp" %>
    </body>
</html>
