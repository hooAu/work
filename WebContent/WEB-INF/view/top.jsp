<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Insert title here</title>
</head>
	<style>
		.menu {
			text-align:left;
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
				<small >${hello }</small>
				<hr/>
				<div class="menu">
					<c:if test="${sessionScope.logon == null }">
						<a href="${pageContext.request.contextPath }/join" class="link">회원가입</a>
					</c:if>
						<span style="text-align:right">${sessionScope.logon}</span>
						<a href="${pageContext.request.contextPath }/login" class="link">로그인</a>
						채팅방 개설
						
				</div>
				<hr/>
				
		
	
	
	
	
