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
    
    <title>批假</title>
	<%@include file="../common/context.jsp" %>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/mic/approvalHoliday.css"/>
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
            <form class="ui form" action="${basePath}/approvalHolidayWeb" method="post">
                <h1 class="ui center aligned dividing header">批假</h1>
                <div class="field">
                    <label>学生姓名</label>
                    <div class="ui fluid left icon input">
                        <i class="ui icon student"></i>
                        <input name="" type="text" width="" readonly="readonly" value="${studentname}">
                    </div>
                </div>
                <div class="field">
                    <label>学号</label>
                    <div class="ui fluid left icon input">
						<i class="ui info circle icon"></i>
                        <input name="id" type="text" width="" v-model="sid" readonly="readonly" value="${id}" >
                    </div>
                </div>
                <div class="field">
                    <label>学院专业班级</label>
                    <div class="ui fluid icon input">
                        <input name="" type="text" width="" readonly="readonly"  value="${school}-${classname}">
                    </div>
                </div>
                <div class="field">
                    <label>手机号码</label>
                    <div class="ui fluid left icon input">
                        <i class="ui icon phone"></i>
                        <input name="" v-model="tel" type="text" width="" readonly="readonly" value="${s_phone}">
                    </div>
                </div>
                <div class="field">
                    <label>开始时间</label>
                    <div class="ui fluid left icon input">
                        <i class="calendar icon"></i>
                        <input name="" type="text" width="" value="${b_time}">
                    </div>
                </div>
                <div class="field">
                    <label>结束时间</label>
                    <div class="ui fluid left icon input">
						<i class="calendar icon"></i>
                        <input name="" type="text" width="" value="${e_time}">
                    </div>
                </div>
                <div class="field">
                    <label>原因</label>
                    <div class="ui fluid left icon input">
                        <textarea rows="2">${reason}</textarea>
                    </div>
                </div>
                <div class="field">
                   <label>未上的课程信息</label>
                    <div class="ui fluid left icon input">
                        <textarea rows="2">
                        <c:forEach items = "${CourseName}" var="CourseName">
                        <c:out value="${CourseName},"></c:out>
                        </c:forEach>
                        </textarea>
                    </div>
                </div>
                <div class="field">
                    <label>是否同意</label>
                    <div class="ui selection dropdown">
                        <input name="state" type="hidden" value="">
                        <div class="default text">是否同意</div>
                        <div class="menu">
                            <div class="item">是</div>
                            <div class="item">否</div>
                        </div>
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
            $('.ui.dropdown')
                .dropdown();
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
