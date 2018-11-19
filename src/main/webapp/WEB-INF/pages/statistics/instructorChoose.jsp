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
    
    <title>辅导员查看考勤统计</title>
	<%@include file="../common/context.jsp" %>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/mic/instructorChoose.css"/>
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
			<div class="ui segment raised very padded">
				<h2 class="ui left floated header">辅导员查看考勤统计</h2>
		  		<div class="ui clearing divider"></div>
		  		<form class="ui form" action="${basePath}/instructor/fond" method="post">
			  		<div class="two fields">
			  			<div class="field">
			  				<div class="ui left icon input">
								<input id="date" name="date" type="text" placeholder="请输入日期" value="">
								<i class="time icon"></i>
							</div>	
			  			</div>
			  			<div class="field">
							 <select name="classs" class="ui dropdown">
						    	<option value="">请选择班级</option>
						    	<c:forEach items="${ClasssList}" var="classs">
							    	<option value="${classs.getId()}">
										${classs.getClassname()}
							    	</option>
						    	</c:forEach>
						    </select>
						</div>
			  		</div>
			  		<div class="two fields">
			  			<div class="field">
			  				<select name="section" class="ui dropdown">
						    	<option value="">请选择第几节课</option>
						    	<c:forEach begin="1" end="5" var="temp"> 
							    	<option value="${temp}">
							    		<i class="ui icon male"></i>
										第${temp}节
							    	</option>
						    	</c:forEach>
						    </select>
			  			</div>
			  			<div class="field">
			  			</div>
			  		</div>
			  		<div class="field">
		  				<input type="submit" class="ui button teal right floated" value="查询"/>
		  			</div>
		  		</form>
			</div>
		</div>
        <%@include file="../common/food.jsp" %>
        <script type="text/javascript">
			laydate.render({
				elem: '#date',
				value: new Date()
				});
			$('.ui.dropdown').dropdown();
		</script>
    </body>
</html>
