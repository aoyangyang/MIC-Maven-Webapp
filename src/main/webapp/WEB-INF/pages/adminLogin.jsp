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
    
    <title>管理员登录</title>
	<%@include file="common/context.jsp" %>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/mic/Login.css"/>
    
    
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
        <%@include file="common/top.jsp" %>
            <!--中间-->
		<div class="main">
			<div class="ui raised very padded segment">
				<form action="${basePath}/adminLoginDo" method="post" class="ui form">
					<h1 class="ui center aligned dividing header">管理员登录</h1>
				  	<div class="field">
				  		<label>用户名</label>
				    		<div class="ui fluid left icon input">
						    	<i class="ui icon user"></i>
			    			<input name="username" type="text" placeholder="请输入用户名" value="">
			    			</div>
				    	</div>
				  	<div class="field">
				    	<label>密码</label>
				    	<div class="fields">
				    		<div class="ui fluid left icon input">
						    	<i class="ui icon lock"></i>
				    		<input name="password" type="password" placeholder="请输入密码" value="">
				    		</div>
				  		</div>
				  	</div>
				  	
					<div class="mybutton">
				  		<button class="ui teal right floated button" type="submit"><i class="ui sign in icon"></i>登录</button>
					</div><br /><br />
				</form>
			</div>
		</div>
        <%@include file="common/food.jsp" %>
        <script type="text/javascript">
			$('.ui.radio.checkbox')
			  .checkbox()
			;
			
		</script>
    </body>
</html>
