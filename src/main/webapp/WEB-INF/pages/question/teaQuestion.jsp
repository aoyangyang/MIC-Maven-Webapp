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
    
    <title>设置问题</title>
	<%@include file="../common/context.jsp" %>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/mic/sutIndex.css"/>
    <link rel="stylesheet" type="text/css" href="${basePath}/LigthBox/lightbox.css"/>
    <link href="${basePath}/upload/style.css" rel="stylesheet" />
    <!-- 统计 -->
    <script type="text/javascript" src="${basePath}/js/echarts.common.min.js"></script>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
		.ui.modal{
			min-height: 200px;
			margin-top: -200px;
		}
		.ui.modal.qu{
			min-height: 200px;
			margin-top: -300px;
		}
		/* 上传按钮 */
		.file {
		    position: relative;
		    display: inline-block;
		    background: #D0EEFF;
		    border: 1px solid #99D3F5;
		    border-radius: 4px;
		    padding: 4px 12px;
		    overflow: hidden;
		    color: #1E88C7;
		    text-decoration: none;
		    text-indent: 0;
		    line-height: 20px;
		}
		.file input {
		    position: absolute;
		    font-size: 100px;
		    right: 0;
		    top: 0;
		    opacity: 0;
		}
		.file:hover {
		    background: #AADFFD;
		    border-color: #78C3F3;
		    color: #004974;
		    text-decoration: none;
		}
		.example-image-link {
		    display: inline-block;
		    padding: 2px;
		    margin: 0 0.5rem 1rem 0.5rem;
		    background-color: #fff;
		    line-height: 0;
		    border-radius: 4px;
		    transition: background-color 0.5s ease-out;
		}
		.ui.stacked.segment{
			min-height: 200px;
		}
		#containers {
			padding: 0 50px;
		}
	</style>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

    </head>
  
    <body id="box">
        <%@include file="../common/top.jsp" %>
        <!--中间-->
		<div class="main">
			<div class="ui raised very padded segment">
				<h2>设置问题</h2>
				${courseNote.name } | ${courseNote.getIntroduction() } | ${courseNote.begin_time } | ${courseNote.end_time }
				<div class="ui divider"></div>
				<h3><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">PPT</font></font></h3>
				<button class="ui button right floated" onclick="addPpt()">添加PPT</button>
				<button class="ui button red right floated" onclick="deletePpt()">删除PPT</button>
				<br /><br />
				<c:forEach var="img" items="${pptImgList }">
					<a class="example-image-link" href="${basePath }/${pptPath }/${img }" data-lightbox="example-set" data-title="">
						<img class="example-image ui medium rounded image medium" src="${basePath }/${pptPath }/${img }"  title="" style="">
					</a>
				</c:forEach>
				
				<div class="ui divider"></div><h3><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">问题</font></font></h3>
				<button class="ui button right floated" onclick="addQu()">添加问题</button>
				<br /><br />
				
				<c:forEach items="${proList }" var="pro">
					<div class="ui stacked segment">
						<div class="ui slider checkbox">
						  <input type="checkbox" name="newsletter">
						  <label>批量提问</label>
						</div><br /><br />
						<h3>问题</h3>
						${pro.problem }
						<br />
						<h3>答案</h3>
						${pro.answer }
						<br />
						<h3>是否为匿名问题</h3>
						<c:if test="${pro.anonymity ==0}">
							不是
						</c:if>
						<c:if test="${pro.anonymity ==1}">
							是
						</c:if>
						<br />
						
						<c:if test="${!empty pro.imgsrc }">
							<a class="example-image-link" href="${basePath }/probImg${pro.imgsrc }" data-lightbox="example-set" data-title="">
								<img class="example-image ui medium rounded image medium" src="${basePath }/probImg${pro.imgsrc }"  title="" style="">
							</a>
						</c:if>
						
						
						<br /><br />
						<c:if test="${pro.dispark ==0}">
							<button class="ui button right floated" onclick="doQu('${pro.id }')">提问</button>
						</c:if>
						<c:if test="${pro.dispark ==1}">
							<button class="ui button right floated" onclick="showQuBack('${pro.id }')">查看答题结果</button>
						</c:if>
						<button class="ui button red right floated" onclick="deleteQu('${pro.id }')">删除问题</button>
						<br /><br />
					</div>
				</c:forEach>
				
				<script type="text/javascript">
					doQu = function(no){
						$.ajax({
							type: "post",
							url:"${basePath}/teacher/problem/doQu",
							data:{"no":no},
							success:function(date){
								if(date=="success"){
									location.reload();
								}
							}
						});
					}
					
					showQuBack = function(){
						$(".ui.modal.statistical").modal("show");
						
						 // 基于准备好的dom，初始化echarts实例
				        var myChart = echarts.init(document.getElementById('containers'));
				
				        // 指定图表的配置项和数据
				        var option = {
				            title: {
				                text: '统计结果'
				            },
				            tooltip: {},
				            legend: {
				                data:['人数']
				            },
				            xAxis: {
				                data: ["A","B","C","D"]
				            },
				            yAxis: {},
				            series: [{
				                name: '销量',
				                type: 'bar',
				                data: [5, 20, 36, 10]
				            }]
				        };
				
				        // 使用刚指定的配置项和数据显示图表。
				        myChart.setOption(option);
					}
				</script>
				
				<button class="ui button right floated" onclick="doListQu()">批量提问</button>
			</div>
		</div>
		
		<!-- 弹出统计图 -->
		<div class="ui modal statistical">
			<div class="ui segment basic" >
				<div id="containers" style="width: 400px;height:300px;margin:0 ,auto;margin-top: 60px"></div>
			</div>
		</div>
		
		<!-- 上传ppt弹出层 -->
		<div class="ui modal ppt">
			<div class="ui center aligned segment basic">
				<h2 class="ui header">选择文件</h2>
				<form action="${basePath}/teacher/problem/upPPt" method="post" enctype="multipart/form-data" target="nm_iframe">
					<a href="javascript:;" class="file">选择文件
					    <input type="file" name="file" id="ppt">
					</a>
					<input type="text" value="${courseNote.id }" name="courseNoteId" style="display:none;" >
					<br /><br /><br /><button class="ui button"  type="submit">上传</button>
				</form>
				<iframe id="id_iframe" name="nm_iframe" style="display:none;"></iframe>
			</div>
		</div>
		
		<!-- 设置问题弹出层 -->
		<div class="ui modal qu">
			<div class="ui center aligned segment basic">
				<h2 class="ui header">提问</h2>
				

			<div class="ui placeholder segment">
				<div class="ui two column very relaxed stackable grid">
					<div class="column">
						<div class="ui form">
							<div class="field">
								<label>问题</label>
								<textarea id="quText" rows="2" style="margin-top: 0px; margin-bottom: 0px; height: 60px;"></textarea>
							</div>
							<div class="field">
								<label>答案</label>
								<input id="quAns" type="text"> 
							</div>
							<div class="field">
								<div class="ui checkbox">
								  <input type="checkbox" id="exampleQu">
								  <label>是否匿名</label>
								</div>
							</div>
							<div class="ui blue submit button" onclick="addQuestion()">提交</div>
						</div>
					</div>
					
					<div class="middle aligned column">
						<form id="upload" method="post" action="${basePath}/teacher/problem/photoUpload" enctype="multipart/form-data">
				            <div id="drop">
				                拉入
				           		<br />
				                <a>浏览</a>
				                <input type="file" name="upl" id="quImgFile" multiple />
				                <input name="imgNo" type="text" style="display: none;" value="${courseNote.id }">
				            </div>
				            <ul>
				                <!-- The file uploads will be shown here -->
				            </ul>
				        </form>
					</div>
				</div>
				<div class="ui vertical divider">图片</div>
			</div>


			<form action="${basePath}/teacher/problem/upPPt" method="post" enctype="multipart/form-data" target="nm_iframe">
					
				</form>
				<iframe id="id_iframe" name="nm_iframe" style="display:none;"></iframe>
			</div>
		</div>
        <script type="text/javascript">
        	//添加ppt
			var addPpt = function(){
				$(".ui.modal.ppt").modal("show");
			}
			
			var addQu = function(){
				$(".ui.modal.qu").modal("show");
			}
			
			//删除ppt
			var deletePpt = function(){
				if(confirm("是否移除ppt？")){
					$.ajax({
						type:'post',
						url:'${basePath}/teacher/problem/deletPPt',
						data:{'no':${courseNote.id }},
						success:function(data){
							if(data=="success"){
								alert("移除成功！");
								location.reload();
							}else{
								alert("移除失败！");
							}
						}												
					})
				}
			}
			
		    
		    /* 提交问题 */
		    addQuestion = function(){
		    	var quText = $("#quText").val();
		    	var quAns = $("#quAns").val();
		    	var exampleQu = $("#exampleQu").is(':checked');
		    
		    	$.ajax({
		    		type: "post",
		    		url:"${basePath}/teacher/problem/addQu",
		    		data:{
		    				"quText":quText,
		    				"quAns":quAns,
		    				"exampleQu":exampleQu,
		    				"no":${courseNote.id }
		    				},
		    		success:function(date){
		    			if(date=="success"){
							alert("建立成功！");
							location.reload();		    			
		    			}else{
		    				alert("建立失败！");
		    			}
		    		}
		    	});
		    }
		    
		    
		    lightbox.option({
		      'resizeDuration': 200,
		      'wrapAround': true,
		      'alwaysShowNavOnTouchDevices':true
		    });
		    
        </script>
        
        
        
        
        <%@include file="../common/food.jsp" %>
        
      	<script src="${basePath}/upload/jquery.knob.js"></script>

        <!-- jQuery File Upload Dependencies -->
        <script src="${basePath}/upload/jquery.ui.widget.js"></script>
        <script src="${basePath}/upload/jquery.iframe-transport.js"></script>
        <script src="${basePath}/upload/jquery.fileupload.js"></script>

        <!-- Our main JS file -->
        <script src="${basePath}/upload/script.js"></script>
        
      
       	<script type="text/javascript" src="${basePath}/LigthBox/lightbox.js"></script>
       	
      
    </body>
</html>
