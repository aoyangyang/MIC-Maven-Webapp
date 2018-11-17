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
    
    <title>请假</title>
	<%@include file="../common/context.jsp" %>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/mic/pVacation.css"/>
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
            <form class="ui form" action="${basePath}/pVacation" method="post">
                <h1 class="ui center aligned dividing header">请假</h1>
                <div class="field">
                    <label>学生姓名</label>
                    <div class="ui fluid left icon input">
                        <i class="ui icon student"></i>
                        <input name="Sname" type="text" readonly="readonly" value="雷">
                    </div>
                </div>
                <div class="field">
                    <label>学号</label>
                    <div class="ui fluid left icon input">
                        <i class="ui info circle icon"></i>
                        <input name="Sid" type="text" v-model="sid" id="Studentid" placeholder="请输入学号" value="">
                    </div>
                </div>
                <div class="field">
                    <label>手机号码</label>
                    <div class="ui fluid left icon input">
                        <i class="ui icon phone"></i>
                        <input name="Pnum" v-model="tel" type="text" id="phone" placeholder="请输入11位手机号码" value="">
                    </div>
                </div>
                <div class="field">
                    <label>开始时间</label>
                    <div class="ui fluid left icon input">
                        <i class="calendar icon"></i>
                        <input name="Btime" type="text" value="" id="start1">
                    </div>
                </div>
                <div class="field">
                    <label>结束时间</label>
                    <div class="ui fluid left icon input">
                        <i class="calendar icon"></i>
                        <input name="Etime" type="text" value="" id="start2">
                    </div>
                </div>
                <div class="field">
                    <label>原因</label>
                    <div class="ui fluid left icon input">
                        <textarea rows="2" name = "reson"></textarea>
                    </div>
                </div>
                <div class="B">
                    <button class="ui teal button">
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
            var vm = new Vue({
                el: "#phone",
                data: {
                    message: ''
                },
                methods: {},
                watch: {
                    tel: function () {
                        var patrn = /^[0-9]*$/;
                        if (!patrn.test(this.tel)) {
                            alert('手机号只能是纯数字')
                        }
                        if (this.tel.length > 11) {
                            alert('手机号只能为11位')
                        }
                    }
                }
            });
            var vm = new Vue({
                el: "#Studentid",
                data: {
                    message: ''
                },
                methods: {},
                watch: {
                    sid: function () {
                        var patrn = /^[0-9]*$/;
                        if (!patrn.test(this.sid)) {
                            alert("学号必须为纯数字")
                        }
                    }
                }
            });
        </script>
    </body>
</html>
