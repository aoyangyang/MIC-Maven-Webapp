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
    
    <title>管理员首页</title>
	<%@include file="../common/context.jsp" %>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/admin.css"/>
    
    
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
        <div class="top">
		<!--头部-->
		<div class="ui segment fixed menu stackable">
				<div class="top-main">
					<!--logo-->
					<div class="ui image logo">
						<img src="img/logo.png"/>
					</div>
					<div class="top-main-right">
						<a href="${basePath}/admin/addSchool">
							<button class="ui button inverted blue  ">
								添加学校
							</button>
						</a>
					</div>
				</div>
			</div>
		</div>
        <!--中间-->
		<div class="main">
			<div class="ui grid">
				<div class="eight wide column">
					<div class="ui raised segment myMain">
						<h3 class="ui header"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">部门用户管理</font></font></h3>
						<div class="ui section divider"></div>
						<table class="ui celled padded table">
							<thead>
								<tr>
									<th>ID</th>
									<th>用户名</th>
									<th>修改</th>
									<th>删除</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${leaderList }" var="temps">
									<tr>
										<td>
											<h2 class="ui center aligned header">${temps.id }</h2>
										</td>
										<td class="single line">${temps.username }</td>
										<td>
											<button class="ui button inverted blue" onclick="">
												修改
											</button>
										</td>
										<td >
											<button class="ui button inverted red">
												删除
											</button>
										</td>
									</tr>
								</c:forEach>
							</tbody>
							<tfoot>
							<tr>
								<th colspan="5">
									<div class="ui right floated pagination menu">
										<a class="icon item">
								          <i class="left chevron icon"></i>
								        </a>
										 <c:if test="${leaderPage >=5}">
									        <c:forEach var="i" begin="1" end="5">
												<a class="item">${i }</a> 
											</c:forEach>
								        </c:if>
										 <c:if test="${leaderPage <5}">
									        <c:forEach var="i" begin="1" end="${leaderPage-1 }">
												<a class="item">${i }</a> 
											</c:forEach>
								        </c:if>
										<a class="icon item">
								          <i class="right chevron icon"></i>
								        </a>
									</div>
								</th>
							</tr>
						</tfoot>
					</table>
				</div>
				</div>
				
				<div class="eight wide column">
					<div class="ui raised segment myMain">
						<h3 class="ui header"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">学生用户管理</font></font></h3>
						<div class="ui section divider"></div>
						<table class="ui celled padded table">
							<thead>
								<tr>
									<th>ID</th>
									<th>用户名</th>
									<th>修改</th>
									<th>删除</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${stuList }" var="temps">
									<tr>
										<td>
											<h2 class="ui center aligned header">${temps.id }</h2>
										</td>
										<td class="single line">${temps.username }</td>
										<td>
											<button class="ui button inverted blue" onclick="">
												修改
											</button>
										</td>
										<td >
											<button class="ui button inverted red">
												删除
											</button>
										</td>
									</tr>
								</c:forEach>
							</tbody>
							<tfoot>
							<tr>
								<th colspan="5">
									<div class="ui right floated pagination menu">
										<a class="icon item">
								          <i class="left chevron icon"></i>
								        </a>
								        <c:if test="${stuPage >=5}">
									        <c:forEach var="i" begin="1" end="5">
												<a class="item">${i }</a> 
											</c:forEach>
								        </c:if>
										 <c:if test="${stuPage <5}">
									        <c:forEach var="i" begin="1" end="${stuPage-1 }">
												<a class="item">${i }</a> 
											</c:forEach>
								        </c:if>
										<a class="icon item">
								          <i class="right chevron icon"></i>
								        </a>
									</div>
								</th>
							</tr>
						</tfoot>
					</table>
					</div>
				</div>
				
				<div class="eight wide column">
					<div class="ui raised segment myMain">
						<h3 class="ui header"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">老师用户管理</font></font></h3>
						<div class="ui section divider"></div>
						<table class="ui celled padded table">
							<thead>
								<tr>
									<th>ID</th>
									<th>用户名</th>
									<th>修改</th>
									<th>删除</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${teaList }" var="temps">
									<tr>
										<td>
											<h2 class="ui center aligned header">${temps.id }</h2>
										</td>
										<td class="single line">${temps.username }</td>
										<td>
											<button class="ui button inverted blue" onclick="">
												修改
											</button>
										</td>
										<td >
											<button class="ui button inverted red">
												删除
											</button>
										</td>
									</tr>
								</c:forEach>
							</tbody>
							<tfoot>
							<tr>
								<th colspan="5">
									<div class="ui right floated pagination menu">
										<a class="icon item">
								          <i class="left chevron icon"></i>
								        </a>
										 <c:if test="${teaPage >=5}">
									        <c:forEach var="i" begin="1" end="5">
												<a class="item">${i }</a> 
											</c:forEach>
								        </c:if>
										 <c:if test="${teaPage <5}">
									        <c:forEach var="i" begin="1" end="${teaPage-1 }">
												<a class="item">${i }</a> 
											</c:forEach>
								        </c:if>
										<a class="icon item">
								          <i class="right chevron icon"></i>
								        </a>
									</div>
								</th>
							</tr>
						</tfoot>
					</table>
					</div>
				</div>
				
				<div class="eight wide column">
					<div class="ui raised segment myMain">
						<h3 class="ui header"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">学校管理</font></font></h3>
						<div class="ui section divider"></div>
						<table class="ui celled padded table">
							<thead>
								<tr>
									<th>ID</th>
									<th>用户名</th>
									<th>修改</th>
									<th>删除</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${schList }" var="temps">
									<tr>
										<td>
											<h2 class="ui center aligned header">${temps.id }</h2>
										</td>
										<td class="single line">${temps.s_name }</td>
										<td>
											<button class="ui button inverted blue" onclick="">
												修改
											</button>
										</td>
										<td >
											<button class="ui button inverted red">
												删除
											</button>
										</td>
									</tr>
								</c:forEach>
							</tbody>
							<tfoot>
							<tr>
								<th colspan="5">
									<div class="ui right floated pagination menu">
										<a class="icon item">
								          <i class="left chevron icon"></i>
								        </a>
										 <c:if test="${schPage >=5}">
									        <c:forEach var="i" begin="1" end="5">
												<a class="item">${i }</a> 
											</c:forEach>
								        </c:if>
										 <c:if test="${schPage <5}">
									        <c:forEach var="i" begin="1" end="${schPage-1 }">
												<a class="item">${i }</a> 
											</c:forEach>
								        </c:if>
										<a class="icon item">
								          <i class="right chevron icon"></i>
								        </a>
									</div>
								</th>
							</tr>
						</tfoot>
					</table>
					</div>
				</div>
			</div>
			
		</div>
        <%@include file="../common/food.jsp" %>
        <script type="text/javascript">
			$('.ui.radio.checkbox')
			  .checkbox()
			;
			
		</script>
    </body>
</html>
