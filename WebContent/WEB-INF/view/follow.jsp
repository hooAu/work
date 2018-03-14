<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ include file="top.jsp" %>

<script src = "https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<style>
		.join{
			width:200px;
		}
		.joinFont{
			text-align:left;
			
		}
	</style>



		<div style="width:200px; margin-top:70px" >
			<h4>- 친구추가 -</h4>
			
			<form action="${pageContext.request.contextPath }/follow" method="post">
			<div  class="joinFont"><small><b>사용자 목록</b></small></div>
			<div>
				<select  name="target" class="join" >
					<c:forEach var="i" items="${follow }">
						<option value="${i.ID }">${i.ID }</option>
					</c:forEach>
				</select>
			</div><br/>
	
			
					
			
			<button type="submit" class="join">친구신청</button>
				
		</form>

		</div>
	</div>
</div>		

</body>
</html>