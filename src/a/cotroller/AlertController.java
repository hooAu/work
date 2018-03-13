package a.cotroller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Controller("alertController")
public class AlertController extends TextWebSocketHandler{
	
	Map<String,List<WebSocketSession>> sessions;
	
	public void init() {
		sessions = new HashMap<>();
	}
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		String key = "";	// HttpSession을 접근해서 정보를 얻어와야 한다.
		
		if(!sessions.containsKey(key))
			sessions.put(key, new ArrayList<>());
		sessions.get(key).add(session);
		
		
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
	
	}
	
}
