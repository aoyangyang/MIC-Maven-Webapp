<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
				<form class="ui form">
					<h1 class="ui center aligned dividing header">添加班级</h1>
					  	<div class="field">
					   		<label>选择学院/学部</label>
					      	<div class="ui selection dropdown">
							    <input name="AddDepartments" type="hidden" value="">
							    	<div class="default text"><i class="ui block layout icon"></i>选择学院/学部</div>
							    		<i class="dropdown icon"></i>
						      		<div class="menu">
							    		<div class="item" data-value="LG"><i class="ui block layout icon"></i> 理工学部 </div>
						        		<div class="item" data-value="RW"><i class="ui block layout icon"></i> 人文学部 </div>
							        	<div class="item" data-value="SK"><i class="ui block layout icon"></i> 生科学部 </div>
						        		<div class="item" data-value="JG"><i class="ui block layout icon"></i> 经管学部 </div>
						        		<div class="item" data-value="XK"><i class="ui block layout icon"></i> 信息科学技术学院 </div>
							      	</div>
							</div>
							<!--<select class="ui fluid one dropdown">
					        	<option value="">选择学院/学部</option>
					        	<option value="DF">理工学部</option>
					    		<option value="XX">信息科学技术学院</option>
					    		<option value="DW">动物科学技术学院</option>
					    		<option value="GG">公共管理与法学学院</option>
					      </select>-->
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
		</script>
    </body>
</html>
