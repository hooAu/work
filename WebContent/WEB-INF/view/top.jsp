<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Git Project</title>
</head>
	<style>
		.menu {
			text-align:left;
			background-color:#F2F2F2;
			height:25px;
		}
		.link {
			text-decoration:none;
			color:black;
		}
	</style>
<body>
	<div align="center">
		<div style="width:800px">
			<h4>Git을 이용한 프로젝트 관리</h4>	
			
				
				<div class="menu">
					<div style="float:left; margin-left:15px; margin-top:4px;">
						<c:choose>
							<c:when test="${sessionScope.logon == null }">
								<a href="${pageContext.request.contextPath }/join" class="link"><small><b>회원가입</b></small></a>
								 &nbsp;<a href="${pageContext.request.contextPath }/login" class="link"><small><b>로그인</b></small></a>
							</c:when>
							<c:otherwise>
							 <a href="${pageContext.request.contextPath }/index" class="link"><small><b>홈</b></small></a> 
							  &nbsp;<a href="${pageContext.request.contextPath }/follow" class="link"><small><b>친구추가</b></small></a>	  
							  &nbsp;<a href="${pageContext.request.contextPath }/showfollow" class="link"><small><b>친구목록</b></small></a>	  
							</c:otherwise>
						</c:choose>
					</div>
					<div style="float:right; margin-right:15px;margin-top:4px;">
						<c:if test="${sessionScope.logon != null }">
							<a href="${pageContext.request.contextPath }/logout" class="link"><small><b>로그아웃</b></small></a>&nbsp;   
							<a href="${pageContext.request.contextPath }/flist" class="link"><small><b>${sessionScope.logon}</b></small></a>
						</c:if>
					</div>
						
						
				</div>
				
		
	
	
	
	
