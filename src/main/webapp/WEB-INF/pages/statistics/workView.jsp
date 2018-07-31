<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>学工组查看考勤统计</title>
	<%@include file="../common/context.jsp" %>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/mic/workView.css"/>
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
				<h2 class="ui left floated header">学工组查看考勤统计</h2>
		  		<div class="ui clearing divider"></div>
				<!--统计图-->
				<h4 class="ui horizontal divider header"><i class="bar chart icon"></i>第一大节课</h4>
				<div class="ui stackable three column grid">
  					<div class="column">
  						<div class="ui segment basic vertical t">
							<h5>计算机一班</h5>
							<div class="ui center aligned segment vertical basic">
								<!--  =================  -->
								<!--       = 统图 =       -->
								<!--  =================  -->
								<div id="chartdiv" 
									style=" width: 100%;
					 				height: 300px;"
					 				></div>
								<script>
									var chart = AmCharts.makeChart( 
										"chartdiv", {
									    	"type": "pie",
									 		 "theme": "light",
									 		 "dataProvider":
									 		 [{
									   		 	"country": "到课",
									  		 	 "litres": 30
									 		 },{
											    "country": "请假",
											    "litres": 5
											 },{
											    "country": "旷课",
											    "litres": 2
											 }],
											
										    "valueField": "litres",
										  	"titleField": "country",
										  	 "balloon":{
										  	 "fixedPosition":true}
										} );
								</script>
							</div>
							<button class="ui right floated teal button">查看详情</button>	
						</div>
  						
  						
  					</div>
					<div class="column">
						
						<div class="ui segment basic vertical t">
							<h5>计算机二班</h5>
							<div class="ui center aligned segment vertical basic">
								<!--  =================  -->
								<!--       = 统图 =       -->
								<!--  =================  -->
								<div id="chartdiv1" 
									style=" width: 100%;
					 				height: 300px;"
					 				></div>
					 				
								<script>
									var chart = AmCharts.makeChart( 
										"chartdiv1", {
									    	"type": "pie",
									 		 "theme": "light",
									 		 "dataProvider":
									 		 [{
									   		 	"country": "到课",
									  		 	 "litres": 20
									 		 },{
											    "country": "请假",
											    "litres": 15
											 },{
											    "country": "旷课",
											    "litres": 12
											 }],
										    "valueField": "litres",
										  	"titleField": "country",
										  	 "balloon":{
										  	 "fixedPosition":true}
										} );
								</script>
							</div>
							<button class="ui right floated teal button">查看详情</button>	
						</div>
					</div>
					<div class="column">33333333</div>
				</div>
			</div>
		</div>
        <%@include file="../common/food.jsp" %>
        <script type="text/javascript">
			laydate.render({elem: '#test1'});
			
			var vm = new Vue({
				el:"#box",
				data:{
					message:''
				},
				methods:{
				},
				watch:{
					tel: function(){
						if(this.tel.length>10){
							this.message='您输入的超长了'
						}
						if(this.tel.length<10){
							this.message=''
						}
					}
				}
			});
		</script>
    </body>
</html>
