package a.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.socket.WebSocketSession;

public class WebSession {
	
	public Map<String,List<WebSocketSession>> createMap() {
		return new HashMap<>();
	}
	
}
