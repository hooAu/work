<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="top.jsp" %>



			<div style="width:200px; margin-top:70px" >
				<h4>인증이 필요합니다.</h4>
				<form action="${pageContext.request.contextPath }/auth" method="post">
					<button type="submit">인증번호 받기</button>
				</form>
			
			</div>
		</div>
	</div>
</body>
</html>