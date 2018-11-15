<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
    <script src="${basePath}/js/laydate/laydate.js" type="text/javascript" charset="utf-8"></script>
    
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
                <h1 class="ui center aligned dividing header">上课信息</h1>
                <div class="field">
                    <label>课程名</label>
                    <div class="ui fluid left icon input">
                        <input name="className" type="text" readonly="readonly" value="${className}">
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
                        <input name="" type="text" readonly="readonly" value="${classNum}">
                    </div>
                </div>
                <div class="field">
                    <label>上课开始时间</label>
                    <div class="ui fluid left icon input">
                        <i class="calendar icon"></i>
                        <input name="begintime" type="text" value="" id="start1">
                    </div>
                </div>
                <div class="field">
                    <label>上课结束结束时间</label>
                    <div class="ui fluid left icon input">
                        <i class="calendar icon"></i>
                        <input name="endtime" type="text" value="" id="start2">
                    </div>
                </div>
                <div class="field">
                    <label>上课地点</label>
                    <div class="ui fluid left icon input">
                        <i class="ui icon marker"></i>
                        <input name="" type="text" readonly="readonly" value="${classAddress}">
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
            laydate.render({
                elem: '#start1',
                type: 'datetime'
            });
            laydate.render({
                elem: '#start2',
                type: 'datetime'
            });
        </script>
    </body>
</html>
