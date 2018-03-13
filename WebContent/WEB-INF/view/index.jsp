<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="top.jsp" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
	
	
<script src = "https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
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
			

					<div class="alert alert-info">
						<small><b>현재 접속자 : </b><span id="cnt"></span></small><br/>
						<strong><small><b>서버알림</b></small></strong><span id="info">-</span>
					</div>
			
				<script>
					var ws = new WebSocket("ws://${pageContext.request.serverName}/handle");
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
						$("#cnt").html(obj.cnt);
						$("#info").html(obj.info);
						// map에 data, cnt, info란 이름으로 담아서 보내자.
					}
					
					// 연결이 끊길 때
					ws.onclose = function() {
						window.alert("연결이 해제되었습니다.");
					}

				</script>
			
			</div>
		</div>
	</div>
</body>
</html>