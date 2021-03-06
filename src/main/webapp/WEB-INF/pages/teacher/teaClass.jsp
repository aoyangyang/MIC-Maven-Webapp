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
    
    <title>教师单门课程信息</title>
	<%@include file="../common/context.jsp" %>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/mic/sutIndex.css"/>
    
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		.ui.modal.retroactive{
			margin-top: -200px;
		}		
		.ui.modal.attendance{
			margin-top: -250px;
		}
		
		.ui.modal.attendance img{
			margin: 0 auto;
		}
	</style>
	
    </head>
  
    <body id="box">
        <%@include file="../common/top.jsp" %>
        <!--中间-->
		<div class="main">
			<div class="ui raised very padded segment">
				<h2>教师单门课程信息</h2>
				<button style="float: right; margin-top: -20px" 
								onclick="toPost()"
										class="ui button inverted blue">
					添加信息
				</button>
				<table class="ui celled table">
					<thead>
						<tr>
							<!-- <th style="color: red;">课程ID</th> -->
							<th>课程名</th>
							<th>开始时间</th>
							<th>结束时间</th>
							<th>上课内容</th>
							<th></th>
							<th></th>
							<th></th>
						</tr>
					</thead>
					
					<c:if test="${!empty coureList }">
						<tbody id="tbo">
							<c:forEach items="${coureList}" var="coure" >
								<tr>
									<%-- <td>${coure.getCourse_id() }</td> --%>
									<td>${coure.getName() }</td>
									<td>${coure.getBegin_time() }</td>
									<td>${coure.getEnd_time() }</td>
									<td>${coure.getIntroduction() }</td>
									<td>
										<a onclick="gotoUpdate(${coure.getId() })">
											<button class="ui button inverted red">
												修改
											</button>
										</a>
									</td>
									<td>
										<a onclick="gotoQu(${coure.getId() })">
											<button class="ui button inverted blue">
												设置问题
											</button>
										</a>
									</td>
									<td>
										<a onclick="gotoCheck(${coure.getId() })">
											<button class="ui button inverted blue">
												点到
											</button>
										</a>
										<a onclick="supplement(${coure.getId() })">
											<button class="ui button inverted blue">
												补签
											</button>
										</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
						<div class="ui modal attendance">
							<div class="ui center aligned segment basic">
								<h2 class="ui header">选择点到方式</h2>
								<input type="text" style="display: none;" id="checkTemp">
								<div class="ui center aligned segment basic">
									<div class="ui stackable two column grid">
										<div class="column">
											<div class="ui center aligned segment ">
												<img class="ui medium rounded image" src="${basePath }/img/Diandao1.png">
											</div>
											<button class="ui button inverted blue" onclick="gotoCheck1()">
												定位+人脸识别点到
											</button>
										</div>
										<div class="column">
											<div class="ui center aligned segment ">
												<img class="ui medium rounded image" src="${basePath }/img/Diandao2.png">
											</div>
											<button class="ui button inverted blue" onclick="gotoCheck2()">
												毫秒级刷新二维码点到
											</button>
										</div>
									</div>		
								</div>
							</div>
						</div>
						
						<script type="text/javascript">
							/* 跳转到点到页面 */
							function gotoCheck(id){
								$('#checkTemp').val(id);
								/* 将页面弹出 */
								$('.ui.modal.attendance').modal('show');
							}
							/* 定位点到 */
							gotoCheck1 = function(){
								var id = $('#checkTemp').val();
								post('${basePath}/teacher/atendnc', {'noteId':id});
							}
							
							/* 扫码点到 */
							gotoCheck2 = function(){
								var id = $('#checkTemp').val();
								post('${basePath}/teacher/atendnc2', {'noteId':id});
							}
							
							
							/* 跳转到补签页面 */ 	
							supplement = function(courId){
							  	$('.ui.modal.retroactive').modal('show');
							  	$('#attId').val(courId);
							}
							supplementDo = function(){
							  	var attId = $('#attId').val();
							  	var stuId = $("#stuId").val();
							  	$.ajax({
							  		type:"post",
							  		url:"${basePath}/teacher/supplementDo",
							  		data:{"attId":attId,"stuId":stuId},
							  		success:function(date){
							  			if(date=="success"){
							  				alert("补签成功！");
							  				$('.ui.modal').modal('hide');
							  			}else{
							  				alert("补签失败");
							  			}
							  		}
							  	});
							}
						</script>
						<div class="ui modal retroactive">
							<i class="close icon"></i>
							<div class="header">
								<font style="vertical-align: inherit;"><font
									style="vertical-align: inherit;">补签 </font></font>
							</div>
							<form class="ui form">
								<div class="field" style="min-height: 100px ;padding: auto 40px">
									<input type="text" name="attId" id="attId" style="display: none">	
									<div class="ui fluid icon input" style="width: 80%;margin:0 auto; margin-top: 30px;">
										<input type="text" name="stuId" placeholder="学生Id" id="stuId">
									</div>
								</div>
								<div class="actions">
									<div class="ui black deny button">
										<font style="vertical-align: inherit;"><font
											style="vertical-align: inherit;">取消</font></font>
									</div>
									<div class="ui positive right labeled icon button" onclick="supplementDo();">
										<font style="vertical-align: inherit;"><font
											style="vertical-align: inherit;">确定</font></font><i
											class="checkmark icon"></i>
									</div>
								</div>
							</form>
						</div>
					<tfoot>
							<tr>
								<th colspan="7">
									<div class="ui right floated pagination menu">
										<c:forEach begin="1" end="${length}" var="i">
											<a class="item" onclick="doIt(${i})">${i}</a> 
										</c:forEach>
									</div>
								</th>
							</tr>
						</tfoot>
					</c:if>
					<c:if test="${empty coureList }">
						此课程还无课程信息，请添加
					</c:if>
					
					
				</table>
			</div>
		</div>
		
        <script type="text/javascript">
        	$('.ui.radio.checkbox').checkbox();

			function doIt(number) {
				$.ajax({
					type: "post",
					url: "${basePath}/teacher/classNo",
					data: {
						"number": number,
						"no": ${coureList.get(0).getCourse_id()}
					},
					success: function(data) {
						val = eval(data);
						var dHtml = '';
						for(i in val) {
							dHtml += /* '<tr><td>'+val[i].course_id+'</td>'+ */
								'<tr>' +
								'<td>' + val[i].name + '</td>' +
								'<td>' + val[i].begin_time + '</td>' +
								'<td>' + val[i].end_time + '</td>' +
								'<td>' + val[i].introduction + '</td>' +
								'<td><a onclick="gotoUpdate(' + val[i].id + ')">' +
								'<button class="ui button inverted red">修改</button>' +
								'</a></td>' +
								'<td><a onclick="gotoQu(' + val[i].id + ')">' +
								'<button class="ui button inverted blue">设置问题</button>' +
								'</a></td>' +
								'<td><a onclick="gotoCheck(' + val[i].id + ')">' +
								'<button class="ui button inverted blue">点到</button>' +
								'</a></td></tr>';
						}
						$("#tbo *").remove();
						$("#tbo").html(dHtml);
					}
				});
			}

			function gotoUpdate(id) {
				var courseId = ${coureList.get(0).getCourse_id()};
				var temp = confirm("修改课程信息需要重新上传课件!!\n是否继续？");
			        		if(temp){
			        			window.location.replace("${basePath}/teacher/classUpMsg/"+courseId+"/"+id);
        		}
        	}
        	/* 跳转到设置问题页面 */
        	function gotoQu(id){
        		window.location.replace("${basePath}/teacher/problem/"+id);
        	}
        	
			
			/* 跳转到添加这门课程的页面 */
			function toPost(){
				var cId = ${coureList.get(0).getCourse_id()};
				post("${basePath}/teacher/eClass", {'cId':cId});
			}
        </script>
        <%@include file="../common/food.jsp" %>
    </body>
</html>
