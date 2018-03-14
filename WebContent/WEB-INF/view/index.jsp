<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="top.jsp" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
	
	
<script src = "https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

	
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
			

					
					
				<script>
					var ws = new WebSocket("ws://${pageContext.request.serverName}:5050/logon");
					// 새로고침한다거나 하면 연결이 끊기면서 새로운 websocket이 생성된다.
					// 192.168.10.66 대신, ${pageContext.request.serverName} 을 적어도 같은 효과.
					
					// 연결이 됐을 때
					ws.onopen = function() {
						console.log("opened ");
						console.log(this);
					}
					// 메시지가 들어올 때
					ws.onmessage = function(resp) {
						// JSON.parse(resp.data)를 이용해서 메시지를 처리하면된다.
						console.log(resp);
						var obj = JSON.parse(resp.data);
						var out = "";
						if(obj.content == "req") {
							out += "친구신청을 하였습니다.";
						} else if(obj.content == "accept") {
							out += "친구신청을 수락하였습니다.";
						} else if(obj.content == "deny") {
							out += "친구신청을 거절하였습니다.";
						}
						var msg = obj.from+"님이 " + out;
						window.alert(msg);
					
					}
					
					

				</script>
			
			</div>
		</div>
	</div>
</body>
</html>