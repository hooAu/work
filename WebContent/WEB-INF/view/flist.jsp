<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>   
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
				<h4>대기중인 친구신청 (${fn:length(req) })</h4>
				<form action="${pageContext.request.contextPath }/flist" method="post">
					<c:forEach var="i" items="${req }">
						<div>
						<b>${i.ONE }</b>
						</div>
						<div>
						수락<input type="radio" name="${i.ONE }" value="accept"/> 거절<input type="radio" name="${i.ONE }" value="deny"/>
						</div>
					</c:forEach>
					<br/>
					<div>
						<button type="submit" class="join">응답하기</button>
					</div>
				</form>
				
			
			</div>
		</div>
	</div>		
			
</body>
</html>