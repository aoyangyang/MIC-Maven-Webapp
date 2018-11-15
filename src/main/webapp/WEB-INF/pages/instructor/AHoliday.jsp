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
    
    <title>批假</title>
	<%@include file="../common/context.jsp" %>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/mic/approvalHoliday.css"/>
    <script src="${basePath}/js/laydate/laydate.js" type="text/javascript" charset="utf-8"></script>
    
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
         <br> <br>
            <!--中间-->
    <div class="main">
        <div class="ui raised very padded segment">
               <div class="ui list">
               <h1 class="ui center aligned dividing header">批假</h1>
               <form class="ui form" action="${basePath}/AHolidayWeb"  method="post">
               <c:forEach items = "${aholidaybean}" var="aholidaybean" >
                <div class="field">
                    <div class="ui input">
                        <input name="id" type="hidden" value="${aholidaybean.id}">
                    </div>
                    <div class="ui fluid left icon input">
						<i class="ui icon user"></i>
                        <input name="teacherName" type="submit" value="姓名:${aholidaybean.studentname} 班级：${aholidaybean.classname}">
                    </div>
                </div>
				  <br>
				  </c:forEach>
				  </form>
			   </div>  
        </div>
    </div>
        <%@include file="../common/food.jsp" %>
    </body>
</html>
