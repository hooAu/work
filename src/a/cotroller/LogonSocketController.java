package a.cotroller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import a.service.MessageService;

@Controller("logonSocketController")
public class LogonSocketController extends TextWebSocketHandler{
	@Autowired
	MessageService message;
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		Map<String,Object> map = session.getAttributes();
		String id = (String) map.get("logon");
		
		message.inertId(id,session);
	}
		
		
		

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		Map<String,Object> map = session.getAttributes();
		String id = (String) map.get("logon");
		
		message.remove(id,session);
		
	}
		
		



}
