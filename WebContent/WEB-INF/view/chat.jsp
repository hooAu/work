<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="top.jsp" %>
	
	
	
<style>
		.chat{
			width:200px;
		}
		.chatFont{
			text-align:left;
			
		}
	</style>

	
	<div style="width:200px; margin-top:70px" >
		<h4>-채팅방 개설-</h4>
		
		<form action="${pageContext.request.contextPath }/chat" method="post">
			<div  class="chatFont">방 제목</div>
			<div>
				<input type="text" name="id" class="chat"/>
			</div><br/>
	
			<div class="charFont">PASS</div>
			<div>
				<input type="password" name="pass" class="chat"/>
			</div><br/>
					
			
			<button type="submit" class="chat">방 개설</button>
				
		</form>
	
	</div>

</body>
</html>