package a.cotroller;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import com.google.gson.Gson;

/*
 * ws 통신을 제어할 용도의 컨트롤러
 * 	- WebSocketHandler(interface) 를 implements 걸어서 목적에 맞게 개조해서 사용.
 * 	- 목적에 맞는 WebSocketHandler를 extends 걸어서 사용. 
 * 		TextWebSocketHandler(문자기반) / BinaryWebSocketHandler(파일데이터 주고 받을 시)
 * 
 * WebSocket Handler의 매핑은 어노테이션으로 안된다. spring 설정파일에서....
 */

@Controller("wsController")
public class WsController extends TextWebSocketHandler{
	@Autowired
	Gson gson;
	
	Set<WebSocketSession> wsSessions;
	Map<String,Object> data;
	@PostConstruct	// init-method 역할의 어노테이션 (bean을 component-scan으로 자동등록하므로 이방법을 쓴다.)
	public void init() {
		wsSessions = new LinkedHashSet<>();
		data = new HashMap<>();
	}
	

	
	@Override // 클라이언트 측과 웹소켓 연결 되었을 때 - 자바스크립트로 연결 유도.
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		
		System.out.println("afterConnectionEstablished.. " + session);
		System.out.println(session.getRemoteAddress().getHostName());
		System.out.println(session.getRemoteAddress().getAddress().getHostAddress());
		
		
		wsSessions.add(session);
	
		data.put("cnt", wsSessions.size());
		data.put("info", session.getRemoteAddress().getAddress().getHostAddress() + "가 접속했습니다.");
		
		for(WebSocketSession ws : wsSessions) {
			session.sendMessage(new TextMessage("open"));
			session.sendMessage(new TextMessage(gson.toJson(data)));
		}
		
	
	}
	
	@Override // 클라이언트 측에서 메시지 들어올 때
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		System.out.println("handleTextMessage.. " + session + " / " + message);
	}
	
	
	
	@Override // 클라이언트측과 연결이 해제 될 때
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println("afterConnectionClosed.. " + session);
		
		wsSessions.remove(session);
		data.put("cnt", wsSessions.size());
		data.put("info", session.getRemoteAddress().getAddress().getHostAddress() + "가 접속을 종료했습니다.");
		for(WebSocketSession ws : wsSessions) {
			session.sendMessage(new TextMessage("close"));
			session.sendMessage(new TextMessage(gson.toJson(data)));
		}
		
	}
	
	
	
}
