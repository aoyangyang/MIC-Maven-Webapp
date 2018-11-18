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
    
    <title>上课信息</title>
	<%@include file="../common/context.jsp" %>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/mic/eClass.css"/>
    <script src="${basePath}/laydate/laydate.js" type="text/javascript" charset="utf-8"></script>
    
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
            <form class="ui form" action="${basePath}/eClassWeb"  method="post" enctype="multipart/form-data">
                <h1 class="ui center aligned dividing header">上课信息——id：${cou.id}</h1>
                <div class="field">
                    <label>课程名</label>
                    <div class="ui fluid left icon input">
                        <input name="className" type="text" readonly="readonly" value="${cou.course_name}">
                    </div>
                </div>
                <div class="field">
                    <label>授课教师</label>
                    <div class="ui fluid left icon input">
                        <input name="" type="text" readonly="readonly" value="${teacherName}">
                    </div>
                </div>
                <div class="field">
                    <label>上课人数</label>
                    <div class="ui fluid left icon input">
                        <input name="" type="text" readonly="readonly" value="${cou.size}">
                    </div>
                </div>
                <div class="field">
                    <label>上课时间</label>
                    <div class="ui fluid left icon input">
                        <i class="calendar icon"></i>
                        <input name="begintime" type="text" value="" id="start1">
                    </div>
                </div>
                <div class="two fields">
	                <div class="field">
	                    <label>开始上课节数</label>
	                    <select name="begain" class="ui dropdown">
	                    	<option value="1">1</option>
	                    	<option value="2">2</option>
	                    	<option value="3">3</option>
	                    	<option value="4">4</option>
	                    	<option value="5">5</option>
	                    	<option value="6">6</option>
	                    	<option value="7">7</option>
	                    	<option value="8">8</option>
	                    	<option value="9">9</option>
	                    	<option value="10">10</option>
	                    	<option value="11">11</option>
	                    	<option value="12">12</option>
	                    </select>
	                </div>
	                <div class="field">
	                    <label>结束上课节数</label>
	                    <select name="end" class="ui dropdown">
	                    	<option value="1">1</option>
	                    	<option value="2">2</option>
	                    	<option value="3">3</option>
	                    	<option value="4">4</option>
	                    	<option value="5">5</option>
	                    	<option value="6">6</option>
	                    	<option value="7">7</option>
	                    	<option value="8">8</option>
	                    	<option value="9">9</option>
	                    	<option value="10">10</option>
	                    	<option value="11">11</option>
	                    	<option value="12">12</option>
	                    </select>
	                </div>
                </div>
               
                <div class="field">
                    <label>上课地点</label>
                    <div class="ui fluid left icon input">
                        <i class="ui icon marker"></i>
                        <input name="" type="text"  value="${cou.address}">
                    </div>
                </div>
                <div class="field">
                    <label>上课内容</label>
                    <div class="ui fluid left icon input">
                        <textarea rows="2" name="Introduction"></textarea>
                    </div>
                </div>
                    <a class="file">
                        <input type="file" name="file" id="">上传课件
                    </a>
                <div class="B">
                    <button class="ui center teal button">
                        <i class="ui sign in icon"></i>提交</button>
                </div>
                <br />
            </form>
        </div>
    </div>
        <%@include file="../common/food.jsp" %>
        <script type="text/javascript">
      	 	$('.ui.dropdown').dropdown();
            laydate.render({
                elem: '#start1',
                value:new Date()
            });
            laydate.render({
                elem: '#start2',
                type: 'datetime'
            });
        </script>
    </body>
</html>
