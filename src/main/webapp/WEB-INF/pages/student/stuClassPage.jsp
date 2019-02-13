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
    
    <title>学生课堂</title>
	<%@include file="../common/context.jsp" %>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/mic/sutIndex.css"/>
    <link rel="stylesheet" type="text/css" href="${basePath}/LigthBox/lightbox.css"/>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

    </head>
  <style>
  	.myBox{
  		width: 100%;
  	}
  	.myBox img{
  		margin-bottom: 5px;
  	}
  	.myBox p{
  		margin-bottom: 10%;
  	}
  	
  	.problemDiv{
		moz-user-select: -moz-none; 
		-moz-user-select: none; 
		-o-user-select:none; 
		-khtml-user-select:none; 
		-webkit-user-select:none; 
		-ms-user-select:none; 
		user-select:none;
  	}
  </style>
    <body id="box">
        <%@include file="../common/top.jsp" %>
            <!--中间-->
		<div class="main">
			<div class="ui raised very padded segment">
				<h2>学生课堂</h2>
				<div class="ui divider"></div>
				<div class="myBox">
					<h4>ppt点击可以放大</h4>
					<div class="ui medium images">
						<c:forEach var="img" items="${pptImgList }">
							<a class="example-image-link" href="${basePath }/${pptPath }/${img }" data-lightbox="example-set" data-title="">
								<img class="example-image ui medium rounded image medium" src="${basePath }/${pptPath }/${img }"  title="" style="">
							</a>
						</c:forEach>
					</div>
					<br /><br />
					<h4>问题</h4>
					<c:forEach items="${problemsList }" var="problem">
						<div class="ui stacked segment">
							<div style="padding: 20px">
								<c:if test="${problem.anonymity == 1 }">
									<h5>此问题为匿名问题</h5>
								</c:if>
								<c:if test="${!empty problem.imgsrc }">
									<h5>图片点击可以放大</h5>
									<div class="ui medium image">
										<a class="example-image-link" href="${basePath }/probImg/${problem.imgsrc }" data-lightbox="example-set" data-title="">
											<img class="example-image ui medium rounded image medium" src="${basePath }/probImg/${problem.imgsrc }"  title="" style="">
										</a>
									</div>
								</c:if>
								<c:if test="${problem.course_note_id == 0}">
									<h5>题目：</h5>
									<div class="problemDiv">
										${problem.problem }
									</div>
									<br />
									<h5>答案：</h5>
									<form action="" method="post"> 
										<div class="ui input">
											<input type="text" >
										</div>
										<button class="ui button" type="button" onclick="answer(this,${problem.id })">提交</button>
									</form>
								</c:if>
							</div>
						</div>
					</c:forEach>
				</div>
				<script type="text/javascript">
					/* 回答问题 */				
					answer = function(obj,no){
						var froms = obj.parentNode;
						var dataText = froms.firstElementChild.firstElementChild.value;
						$.ajax({
							type: "post",
							url:"${basePath}/student/class/page/answer",
							data:{
								"ans":dataText,
								"no":no
							},
							success:function(date){
								if(date == "success"){
									froms.parentNode.removeChild(froms.previousElementSibling);
									froms.parentNode.removeChild(froms);
								}
							}						
						});
					}
				</script>
			</div>
		</div>
        <%@include file="../common/food.jsp" %>
        <script type="text/javascript">
        	gotoClass = function(no){
        		post('${basePath}/student/class/page',{"no":no});
        	}
        
         	lightbox.option({
		      'resizeDuration': 200,
		      'wrapAround': true,
		      'alwaysShowNavOnTouchDevices':true
		    });
        
			$('.ui.radio.checkbox')
			  .checkbox()
			;
			
		</script>
	 	<script type="text/javascript" src="${basePath}/LigthBox/lightbox.js"></script>
    </body>
</html>
