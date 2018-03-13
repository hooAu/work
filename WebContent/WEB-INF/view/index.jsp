<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="top.jsp" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
	
	
	
			<div style="width:500x; margin-top:70px" >
				<c:choose>
					<c:when test="${sessionScope.logon == null}">
					
					</c:when>
					<c:otherwise>
						<h4>${sessionScope.logon }님 환영합니다. 인증절차 후, 웹 채팅을 이용해주세요.</h4>
						
						<a href="${pageContext.request.contextPath }/chat"><button type="button" 
							style="width:130px;height:30px">채팅방 개설하기</button></a>
								
					</c:otherwise>
				</c:choose>
			
				<div id="info">
					
				</div>
				<script>
				var ws = new WebSocket("ws://${pageContext.request.serverName}/alert");
				// 새로고침한다거나 하면 연결이 끊기면서 새로운 websocket이 생성된다.
				// 192.168.10.66 대신, ${pageContext.request.serverName} 을 적어도 같은 효과.
				
				// 메시지가 들어올 때
				ws.onmessage = function(resp) {
					console.log(resp)
					var obj = JSON.parse(resp);
				}
				
				</script>
			
			</div>
		</div>
	</div>
</body>
</html>