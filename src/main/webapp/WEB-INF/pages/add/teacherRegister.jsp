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
    
    <title>老师注册</title>
	<%@include file="../common/context.jsp" %>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/mic/teacherRegister.css"/>
    
    
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
				<form action="${basePath}/TeacherRegisterDo" class="ui form" method="post">
					<h1 class="ui center aligned dividing header">老师注册</h1>
					  	<div class="field">
					    	<label>姓名</label>
					    	<div class="ui fluid left icon input">
						    	<i class="ui icon user"></i>
					        <input name="name" type="text" placeholder="请输入姓名" value="">
					  		</div>
					    </div>
					  	<div class="field">
					    		<label>密码</label>
					    	<div class="ui fluid left icon input">
						    	<i class="ui icon lock"></i>
						    	<input v-model="password1" name="password" type="password" placeholder="请输入登录密码" value="">
					  		</div>
					    </div>
					  	<div class="field">
					    		<label>确认密码</label>
					    	<div class="ui fluid left icon input">
						    	<i class="ui icon lock"></i>
						    <input v-model="password2" name="password1" type="password" placeholder="请再次输入密码" value="">
						    <label class="message" style="float: right;color: red;">
					    		{{passMessage}}
					    	</label>
					    	</div>
					  	</div>
					  	<div class="field">
					    	<label>家庭住址</label>
					    	<div class="ui fluid left icon input">
					    		<i class="ui icon home"></i>
						    	<input v-on:click="test" name="address"  type="text" placeholder="请输入家庭住址" value="">
					  		</div>
					    </div>
					  	<div class="field">
					    	<label>邮箱</label>
					    	<div class="ui fluid left icon input">
								<i class="ui icon mail"></i>					    		
							    <input name="email" type="text" placeholder="请输入邮箱" value="">
					    	</div>
					  	</div>
					  	<div class="field">
					    	<label>手机</label>
					    	<div class="ui fluid left icon input">
						    	<i class="ui icon phone"></i>
							    <input name="phone" type="text" maxlength="11" placeholder="请输入手机号码" value="">
					    	</div>
					  	</div>
					<button class="ui red right floated button" type="submit"><i class="ui write square icon"></i>注册</button><br /><br />
				</form>
			</div>
		</div>
        <%@include file="../common/food.jsp" %>
        <script type="text/javascript">
			var vm = new Vue({
				el:"#box",
				data:{
					password1:'',
					password2:'',
					passMessage:''
				},
				methods:{
					test:function(){
						if(this.password1!=this.password2){
							this.passMessage = '两次密码不同！';
						}
						if(this.password1==this.password2){
							this.passMessage = '';
						}
					}
				},
				watch:{
						/*if(200-this.texts.length<0){
							alert('超出字数限制');
							$('#texts').val($('#texts').val().substr(0,200));
						}*/
						
				}
			});

		</script>
    </body>
</html>
