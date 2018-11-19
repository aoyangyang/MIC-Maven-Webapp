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
    
    <title>院领导查看考勤统计</title>
	<%@include file="../common/context.jsp" %>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/mic/depLeader.css"/>
   	<script src="${basePath}/laydate/laydate.js" type="text/javascript" charset="utf-8"></script>
	<script src="${basePath}/js/amcharts/amcharts.js" type="text/javascript" charset="utf-8"></script>
	<script src="${basePath}/js/amcharts/pie.js" type="text/javascript" charset="utf-8"></script>
	<script src="${basePath}/js/amcharts/light.js" type="text/javascript" charset="utf-8"></script>
    
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
		<div class="ui segment raised very padded">
			<h2 class="ui left floated header">院领导查看考勤统计</h2>
	  		<div class="ui clearing divider"></div>
			<form action="${basePath}/depLeader/DepLeaderDate" method="post">
				<div class="ui left icon input">
					<input id="MyDate" name="MyDate" type="text" placeholder="请输入日期" value="">
					<i class="time icon"></i>
				</div>	
				<button type="submit" class="ui teal button">
					查询
				</button>
			</form>
			<!--统计图-->
			<c:forEach items="${pancakeDateList}" var="pancakeDate">
				<c:if test="${pancakeDate.getAttendance()==0
								&&pancakeDate.getLeave()==0
								&&pancakeDate.getAbsence()==0}">
					<div class="ui segment basic vertical t">
						<h3>${pancakeDate.getPanckeName()}</h3>
						<div class="ui center aligned segment vertical basic">
							<h2>今日无课或无签到信息</h2>
						</div>
					</div>
				</c:if>
				<c:if test="${pancakeDate.getAttendance()!=0
								||pancakeDate.getLeave()!=0
								||pancakeDate.getAbsence()!=0}">
					<div class="ui segment basic vertical t">
						<h3>${pancakeDate.getPanckeName()}</h3>
						<div class="ui center aligned segment vertical basic">
							<!--  =================  -->
							<!--       = 统图 =       -->
							<!--  =================  -->
							<div id="${pancakeDate.getId()}" 
								style=" width: 100%;
				 				height: 300px;"
				 				></div>
							<script>
								var chart = AmCharts.makeChart( 
									"${pancakeDate.getId()}", {
								    	"type": "pie",
								 		 "theme": "light",
								 		 "dataProvider":
								 		 [{
								   		 	"country": "到课",
								  		 	 "litres": ${pancakeDate.getAttendance()}
								 		 },{
										    "country": "请假",
										    "litres": ${pancakeDate.getLeave()}
										 },{
										    "country": "旷课",
										    "litres": ${pancakeDate.getAbsence()}
										 }],
										"fontSize":20,
									    "valueField": "litres",
									  	"titleField": "country",
									  	 "balloon":{
									  	 "fixedPosition":true}
									} );
							</script>
							<!--  ==========  -->
							<!--  = 统计结束 =  -->
							<!--  ==========  -->
						</div>
						<a href="${basePath}/
							depLeader/depLeaderDetail/${pancakeDate.getPanckeName()}/${time}/${pancakeDate.getId()}
						">
							<button class="ui right floated teal button">查看详情</button>	
						</a>
					</div>
				</c:if>
			</c:forEach>
			</div>
		</div>
        <%@include file="../common/food.jsp" %>
        <script type="text/javascript">
			laydate.render({
				elem: '#MyDate',
				value:'${time}'
			});
			
			function fond(){
				var MyDate=$("#MyDate").val();
				
				alert(MyDate)
			};
			
			$("#MyDate").change(function(){
				var MyDate=$("#MyDate").val();
			  /*   $.ajax({
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
				}); */
			 });
			var vm = new Vue({
				el:"#box",
				data:{
				},
				methods:{
				},
				watch:{
				}
			});
		</script>
    </body>
</html>
