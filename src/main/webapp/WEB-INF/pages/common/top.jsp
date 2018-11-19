<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="top">
	<!--头部-->
	<div class="ui segment fixed menu stackable">
		<div class="top-main">
			<!--logo-->
			<div class="ui image logo">
				<img src="img/logo.png"/>
			</div>
			<!--用户状态-->
			<div class="top-main-right">
				<c:if test="${empty studentName && empty teacherName && 
								empty adClassName && empty adDepartmentName && empty adSchoolName}">
					<a href="${basePath}/Login">
						<button class="ui button inverted blue  ">
							登陆
						</button>
					</a>
				</c:if>
				
				<c:if test="${!empty studentName || !empty teacherName 
							|| !empty adClassName || !empty adDepartmentName || !empty adSchoolName}">
					<a>
						<button class="ui button inverted blue  ">
							${studentName}${teacherName}${adClassName}${adDepartmentName}${adSchoolName}
						</button>
					</a>
					<a href="${basePath}/loginOut">
						<button class="ui button inverted red">
								登出
						</button>
					</a>
				</c:if>
				
			</div>
		</div>
	</div>
</div>