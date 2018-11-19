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
    
    <title>学生注册页面</title>
	<%@include file="../common/context.jsp" %>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/mic/studentAdd.css"/>
    
    
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
				<h2 class="ui left floated header">学生注册</h2>
				<div class="ui clearing divider"></div>
				<form class="ui form" 
					action="${basePath}/studentAddDo" 
						enctype="multipart/form-data"
							method="post">
					
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
									<input name="phone" type="text" placeholder="请输入电话号码" value="">
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
						    <label>性别</label>
						    <select name="sex" class="ui dropdown">
						    	<option value="">请选择性别</option>
						    	<option value="1">
						    		<i class="ui icon male"></i>
									男
						    	</option>
						    	<option value="0">
						    		<i class="ui female icon"></i>
									女
						    	</option>
						    </select>
						</div>
					</div>
					
					<div class="field">
						<div class="two fields">
							<div class="field">
								<label>年级</label>
								<select name="enrolment" id="enrolment" class="ui dropdown">
							    	<option value="">请选择年级</option>
							    	<option value="2015">
							    		<i class="ui icon male"></i>
										2015
							    	</option>
							    	<option value="2016">
							    		<i class="ui icon male"></i>
										2016
							    	</option>
							    	<option value="2017">
							    		<i class="ui female icon"></i>
										2017
							    	</option>
							    	<option value="2018">
							    		<i class="ui female icon"></i>
										2018
							    	</option>
					   			</select>
							</div>
						</div>
					</div>
					
					
					
					<div class="field">
						<label>班级学校信息</label>
						<div class="three fields">
							<div class="field">
								 <select name="schoolName" id="schoolName" class="ui dropdown">
							    	<option value="">学校</option>
							    	<c:forEach items="${schoolList}" var="school">
								    	<option value="${school.getId()}">
								    		<i class="ui icon male"></i>
											${school.getS_name()}
								    	</option>
							    	</c:forEach>
							    </select>
							</div>
							<div class="field">
								 <select name="departments" id="departments" class="ui dropdown">
							    	<option value="">学院/学部</option>
							    </select>
							</div>
							<div class="field">
								<div class="field">
									<select name="classs" id="classs" class="ui dropdown">
								    	<option value="">班级</option>
						   			</select>
								</div>
							</div>
						</div>
					</div>
					
					
					<div class="two fields">
						<div class="field">
						    <label>邮箱</label>
						    <div class="ui left icon input">
						    	<i class="ui icon mail"></i>
								<input name="email" type="text" placeholder="请输入邮箱" value="">
							</div>
						</div>
						<div class="field"  id="pic">
						    <label>上传图片</label>
							 <a class="file" onclick="clean()">
		                        <input type="file" name="file" id="file">上传头像
		                    </a>
		                    
						</div>
					</div>
					
				  	<input class="ui right floated teal button" type="submit" value="提交" /><br /><br />
				</form>
			</div>
		</div>
        <%@include file="../common/food.jsp" %>
        <script type="text/javascript">
			$('.ui.dropdown').dropdown();
        	//图片预览
        	$("#file").change(function() {
        		var objUrl = getObjectURL(this.files[0]);
        		console.log("objUrl = " + objUrl);
        		if (objUrl) {
        			$("#img0").remove();
        			$("#pic").append('<img class="ui centered small rounded image" src="" id="img0" >');
        			$("#img0").attr("src", objUrl);
        			$("#img0").removeClass("hide");
        		}
        	}) ;
        
        	function clean() {
        		$("#img0").remove();
        	}
        	function getObjectURL(file) {
        		var url = null;
        		if (window.createObjectURL != undefined) {
        			url = window.createObjectURL(file);
        		} else if (window.URL != undefined) {
        			url = window.URL.createObjectURL(file);
        		} else if (window.webkitURL != undefined) {
        			url = window.webkitURL.createObjectURL(file);
        		}
        		return url;
        	}
        	//通过选择学校得到学院、学部
        	$("#schoolName").change(function(){
				var schoolName=$("#schoolName").val();
			    $.ajax({
					type:"post",
					url:"${basePath}/getDepartments",
					data:{"schoolName":schoolName},
					success:function(data){
						val=eval(data);
						var dHtml = '<option value="">学院/学部</option>';
						for(i in val){
							
							dHtml += '<option value="'+
									val[i].id+
									'">'+
							    	'<i class="ui icon male"></i>'+
										val[i].d_name
							    	'</option>';
						}
						
						$("#departments *").remove();
						$("#departments").html(dHtml);
					}
				});
			});
			
			//通过学院、学部得到班级
			$("#departments").change(function(){
				var departments=$("#departments").val();
				var enrolment = $("#enrolment").val();
			    $.ajax({
					type:"post",
					url:"${basePath}/getClass",
					data:{"departments":departments,
						  "enrolment":enrolment},
					success:function(data){
						val=eval(data);
						var dHtml = '<option value="">班级</option>';
						for(i in val){
							dHtml += '<option value="'+
									val[i].id+
									'">'+
							    	'<i class="ui icon male"></i>'+
										val[i].classname
							    	'</option>';
						}
						
						$("#classs *").remove();
						$("#classs").html(dHtml);
					}
				});
			});
		</script>
    </body>
</html>
