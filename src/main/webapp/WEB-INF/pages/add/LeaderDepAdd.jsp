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
    
    <title>院领导注册</title>
	<%@include file="../common/context.jsp" %>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/mic/LeaderDepAdd.css"/>
    
    
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
				 <h2 class="ui left floated header">院领导注册</h2>
				 <div class="ui clearing divider"></div>

				<form action="${basePath}/LeaderDepAddDo" class="ui form" method="post">
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
									<input name="tel" type="text" placeholder="请输入电话号码" value="">
								</div>
							</div>
						</div>
					</div>
					
					
					<div class="two fields">
						<div class="field">
						    <label>密码</label>
						    <div class="ui left icon input">
						    	<i class="ui icon lock"></i>
								<input name="password1" type="text" placeholder="请输入密码" value="">
							</div>
						</div>
						<div class="field">
						    <label>请再次输入密码</label>
						    <div class="ui left icon input">
						    	<i class="ui icon lock"></i>
								<input name="password2" type="text" placeholder="请再次输入密码" value="">
							</div>
						</div>
					</div>
					
					
					<div class="two fields">
						<div class="field">
						    <label>家庭地址</label>
						    <div class="ui left icon input">
						    	<i class="ui icon home"></i>
								<input name="address" type="text" placeholder="请输入家庭地址" value="">
							</div>
						</div>
						<div class="field">
						    <label>邮箱</label>
						    <div class="ui left icon input">
						    	<i class="ui icon mail"></i>
								<input name="email" type="text" placeholder="请输入邮箱" value="">
							</div>
						</div>
					</div>
					
					<div class="field">
						<label>学校信息</label>
						<div class="two fields">
							<div class="field">
								 <select name="school" class="ui dropdown">
							    	<option value="">学校</option>
							    	<c:forEach items="${schoolList}" var="school"> 
								    	<option value="${school.getId()}">
								    		<i class="ui icon male"></i>
											${school.getS_name()}
								    	</option>
							    	</c:forEach>
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
			var vm = new Vue({
				el:"#box",
				data:{
				},
				methods:{
					
				},
				watch:{
				}
			});
		</script>
    </body>
</html>
