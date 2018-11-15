<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录</title>
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
				<form action="${basePath}/loginDo" method="post" class="ui form">
					<h1 class="ui center aligned dividing header">登录</h1>
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
				  	
				  	<div class="ui form">
					  <div class="inline fields">
					    <label for="defined">选择你的身份</label>
					    <div class="defined">
					      <div class="ui radio checkbox">
					        <input name="defined" tabindex="0" value="1" class="hidden" type="radio" checked="">
					        <label>部门&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
					      </div>
					    </div>
					    <div class="field">
					      <div class="ui radio checkbox">
					        <input name="defined" tabindex="0" value="2" class="hidden" type="radio" >
					        <label>教师</label>
					      </div>
					    </div>
					    <div class="field">
					      <div class="ui radio checkbox">
					        <input name="defined" tabindex="0" value="3" class="hidden" type="radio" >
					        <label>学生</label>
					      </div>
					    </div>
					  </div>
					</div>
					<div class="mybutton">
				  		<button class="ui teal right floated button" type="submit"><i class="ui sign in icon"></i>登录</button>
						<a href="${basePath}/selectAdd" target="_blank">
					  		<button class="ui red button" type="button"><i class="ui write square icon"></i>注册</button>
						</a>
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
