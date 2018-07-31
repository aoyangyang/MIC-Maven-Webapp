<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>管理员添加学校</title>
    <%@include file="../common/context.jsp" %>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/mic/addSchool.css"/>
    
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
			<div class="ui segment very padded raised">
				<h2 class="ui left floated header">管理员添加学校</h2>
		  		<div class="ui clearing divider"></div>
				<div class="ui form"> 
					<form action="admin/addSchoolDo" method="post">
						<div class="field">
							<label>学校名称</label>
							<input type="text" name="schoolName" id="" value="" />
						</div>
						<div class="field" id="fie">
							<label>学院/学部名称</label>
							<input class="school" 
								type="text" 
								name="button0" 
								id="button0" 
								value="button0" />
						</div>
						<input class="ui right floated button" 
								type="button"  
								value="+"
								v-on:click="addInput()"/>
						<input class="ui right floated button" 
								type="button"  
								value="-"
								v-on:click="deleteInput()"/>
						<br /><br /><br />
						<div class="field">
							<input class="ui right floated teal  button" type="submit"  value="提交"/>
						</div><br /><br />
					</form>
				</div>
			</div>
		</div>
      <%@include file="../common/food.jsp" %>
      <script type="text/javascript">
			var vm = new Vue({
				el:"#box",
				data:{
					buttons:'button',
					numbers:0
				},
				methods:{
					addInput:function(){
						var temp = parseInt(this.numbers)+1;
						$("#fie").append('<input class="school" type="text" name='+this.buttons+temp+' id='+this.buttons+temp+' value='+this.buttons+temp+' />');
						this.numbers=temp;
					},
					deleteInput:function(){
						if(this.numbers>0){
							$("#"+this.buttons+this.numbers).remove();
							this.numbers=parseInt(this.numbers)-1;
						}else{
							alert('最少不能少与一个！');
						}
					}
				},
				watch:{
				}
			});
		</script>
  </body>
</html>
