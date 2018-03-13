package a.cotroller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Controller("alertController")
public class AlertController extends TextWebSocketHandler{
	
	Map<String,List<WebSocketSession>> sessions;
	Map<String,Set<String>> logMap;
	
	@PostConstruct
	public void init() {
		sessions = new HashMap<>();
		logMap = new HashMap<>();
	}
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// HttpSession을 접근해서 정보를 얻어와야 한다. 그냥은 안된다...
		// HttpSesisonHandshakeInterceptor를 설정해두면 
		// Spring이 이 메서드를 호출할 때, 이 클라이언트가 사용중인 HttpSession의 setAttribute 되어있는 값들을 
		// WebSocketSession에서 뽑아다 쓸 수 있게 넣어준다.
		// 그러면서 추가로 "HTTP.SESSION.ID"라는 키로 사용중인 session ID 를 넣어준다.
		
		Map<String,Object> map = session.getAttributes();
		System.out.println(map);
		
		
		String key = (String) map.get("HTTP.SESSION.ID");	// HttpSession을 접근해서 정보를 얻어와야 한다.
		String id = (String) map.get("logon");
		
		if(!sessions.containsKey(key))
			sessions.put(key, new ArrayList<>());
		sessions.get(key).add(session);
		
		if(!logMap.containsKey("logon")) 
			logMap.put("logon", new HashSet<>());
		if(!logMap.get("logon").contains(id)) {
			logMap.get("logon").add(id);
		} else {
			for(String s : sessions.keySet()) {
				
			}
		}
		
		
		
		
		
		for(String s : sessions.keySet()) {
			System.out.println(s + " / " + sessions.get(s) + " / " + sessions.get(s).size());
		}
		
	}

	
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		String key = (String)session.getAttributes().get("HTTP.SESSION.ID");
		System.out.println(sessions + " / " + sessions.get(key));
		sessions.get(key).remove(session);
		
		if(sessions.get(key).isEmpty()) {
			sessions.remove(key);
		}
		
	}

}
