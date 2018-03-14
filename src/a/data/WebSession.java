package a.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.socket.WebSocketSession;

// public class WebSocketMap extends HashMap<String,List<WebSocketSession>>
// 이런식으로 만들면 factory-method 설정하지 않아도 된다.

public class WebSession {
	
	public Map<String,List<WebSocketSession>> createMap() {
		return new HashMap<>();
	}

	
	
	
	
	
	
}
