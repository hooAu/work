<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file ="top.jsp" %>



			<div style="width:200px; margin-top:70px" >
				<h4>인증키를 입력해주세요.</h4>
				<form action="${pageContext.request.contextPath }/auth" method="post">
					<div>
						인증키 입력 <input type="number" name="authkey" />
					</div>
				</form>
						
			</div>
		</div>
	</div>
</body>
</html>