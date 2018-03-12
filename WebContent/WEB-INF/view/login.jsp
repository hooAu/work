<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ include file="top.jsp" %>
	


<style>
		.join{
			width:200px;
		}
		.joinFont{
			text-align:left;
			
		}
	</style>

	
	<div style="width:200px; margin-top:70px" >
		<h4>- 로그인 -</h4>
		
		<form action="${pageContext.request.contextPath }/login" method="post">
			<div  class="joinFont"><small><b>ID</b></small></div>
			<div>
				<input type="text" name="id" class="join"/>
			</div><br/>
	
			<div class="joinFont"><small><b>PASS</b></small></div>
			<div>
				<input type="password" name="pass" class="join"/>
			</div><br/>
					
			
			<button type="submit" class="join">로그인</button>
				
		</form>
	
	</div>

</body>
</html>	
	