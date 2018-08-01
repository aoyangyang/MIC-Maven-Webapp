<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>学工组注册</title>
	<%@include file="../common/context.jsp" %>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/mic/LeaderWorkAdd.css"/>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

    </head>
  
    <body>
        <%@include file="../common/top.jsp" %>
       	<!--  ==========  -->
		<!--  = 中间 =  -->
		<!--  ==========  -->
		<div class="main">
			<div class="ui raised segment">
				 <h2 class="ui left floated header">学工组注册</h2>
				 <div class="ui clearing divider"></div>

				<form class="ui form">
					<div class="field">
						<div class="two fields">
							<div class="field">
								<label>姓名</label>
								<div class="ui left icon input">
									<i class="ui icon user"></i>
									<input name="username" type="text" placeholder="请输入姓名" value="">
								</div>
							</div>
							<div class="field">
								<label>电话号码</label>
								<div class="ui left icon input">
									<i class="ui icon phone"></i>
									<input name="username" type="text" placeholder="请输入电话号码" value="">
								</div>
							</div>
						</div>
					</div>
					
					
					<div class="two fields">
						<div class="field">
						    <label>密码</label>
						    <div class="ui left icon input">
						    	<i class="ui icon lock"></i>
								<input name="password" type="text" placeholder="请输入密码" value="">
							</div>
						</div>
						<div class="field">
						    <label>请再次输入密码</label>
						    <div class="ui left icon input">
						    	<i class="ui icon lock"></i>
								<input name="password" type="text" placeholder="请再次输入密码" value="">
							</div>
						</div>
					</div>
					
					
					<div class="two fields">
						<div class="field">
						    <label>家庭地址</label>
						    <div class="ui left icon input">
						    	<i class="ui icon home"></i>
								<input name="name" type="text" placeholder="请输入家庭地址" value="">
							</div>
						</div>
						<div class="field">
						    <label>邮箱</label>
						    <div class="ui left icon input">
						    	<i class="ui icon mail"></i>
								<input name="name" type="text" placeholder="请输入邮箱" value="">
							</div>
						</div>
					</div>
					
					<div class="field">
						<label>学校信息</label>
						<div class="two fields">
							<div class="field">
								 <select name="" class="ui dropdown">
							    	<option value="">学校</option>
							    	<option value="1">
							    		<i class="ui icon male"></i>
										湖南农业大学东方科技学院
							    	</option>
							    	<option value="0">
							    		<i class="ui female icon"></i>
										湖南大学
							    	</option>
							    </select>
							</div>
							<div class="field">
								 <select name="" class="ui dropdown">
							    	<option value="">学院/学部</option>
							    	<option value="1">
							    		<i class="ui icon male"></i>
										理工学部
							    	</option>
							    	<option value="0">
							    		<i class="ui female icon"></i>
										人文学部
							    	</option>
							    </select>
							</div>
						</div>
					</div>
				  	<button class="ui right floated teal button" type="submit">提交</button><br /><br />
				</form>
			</div>
		</div>
        <%@include file="../common/food.jsp" %>
        <script type="text/javascript">
			$('.ui.dropdown').dropdown();
		</script>
    </body>
</html>
