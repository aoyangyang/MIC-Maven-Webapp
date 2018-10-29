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
    
    <title>添加班级</title>
	<%@include file="../common/context.jsp" %>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/mic/instructorAdd.css"/>
    
    
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
				<form  action="${basePath}/InstructorAddDo" class="ui form" method="post">
					<h1 class="ui center aligned dividing header">添加班级</h1>
					
					
					<div class="field">
						<label>学校信息</label>
						<div class="two fields">
							<div class="field">
								 <select name="schoolName" 
									 class="ui dropdown" 
										 id="schoolName">
							    	<option value="">选择所在学校</option>
							    	<c:forEach items="${schoolList}" var="school">
								    	<option value="${school.getId()}">
								    		<i class="ui icon male"></i>
											${school.getS_name()}
								    	</option>
							    	</c:forEach>
							    </select>
							</div>
							<div class="field">
								 <select name="departments" 
								 			class="ui dropdown"
								 			 	id="departments">
							    	<option value="">选择所在学院/学部</option>
							    </select>
							</div>
						</div>
					</div>
					
					
   					<div class="field">
   						<label>填写班级</label>
   						<div class="ui fluid left icon input">
   							<i class="ui student icon"></i>
   							<input name="addClass" type="text" placeholder="请填写要添加的班级，如：计算机16-2" value="">
			    		</div>
   					</div>
						<div class="field">
						    <label>入学年份</label>
						    <div class="ui selection dropdown">
						      	<input name="AddYear" type="hidden" value="">
						      	<div class="default text"><i class="ui ellipsis horizontal icon"></i>年份</div>
						      	<i class="dropdown icon"></i>
						      	<div class="menu">
						        	<div class="item" data-value="2015"><i class="ui ellipsis horizontal icon"></i> 2015级 </div>
						        	<div class="item" data-value="2016"><i class="ui ellipsis horizontal icon"></i> 2016级 </div>
						        	<div class="item" data-value="2017"><i class="ui ellipsis horizontal icon"></i> 2017级 </div>
						        	<div class="item" data-value="2018"><i class="ui ellipsis horizontal icon"></i> 2018级 </div>
						      	</div>
						    </div>
						</div>
   					<div class="field">
   						<label>班级人数</label>
					  	<div class="field">
					    	<div class="ui fluid left icon input">
							    <i class="ui icon users"></i>
				    			<input name="user" type="text" placeholder="请填写班级人数，如：60" value="">
				    		</div>
					    </div>
   					</div>
			  		<button class="ui teal button" type="submit"><i class="ui sign in icon"></i>提交</button><br /><br />
				</form>
			</div>
		</div>
		
		
					
					
					
					
					
					
					
					

        <%@include file="../common/food.jsp" %>
        <script type="text/javascript">
			$('.ui.dropdown').dropdown();
			
			$("#schoolName").change(function(){
				var schoolName=$("#schoolName").val();
			    $.ajax({
					type:"post",
					url:"${basePath}/findDepartments",
					data:{"schoolName":schoolName},
					success:function(data){
						val=eval(data);
						var dHtml = '<option value="">选择学院/学部</option>';
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
		</script>
    </body>
</html>
