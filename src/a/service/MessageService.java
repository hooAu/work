package a.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import com.google.gson.Gson;


@Service
public class MessageService {
	@Autowired
	Map<String,List<WebSocketSession>> ws;
	@Autowired
	Gson gson;
	
	public void inertId(String id, WebSocketSession session) {
		if(!ws.containsKey(id))
			ws.put(id, new ArrayList<>());
		ws.get(id).add(session);
	}

	public void remove(String id, WebSocketSession session) {
		ws.get(id).remove(session);
		if(ws.get(id).isEmpty())
			ws.remove(id);
	}

	public void sendRequest(String one, String other) throws IOException {
		if(ws.containsKey(other)) {
			Map map = new HashMap<>();
				map.put("from", one);
				map.put("content", "req");
			for(WebSocketSession socket : ws.get(other)) {
				socket.sendMessage(new TextMessage(gson.toJson(map)));
			}
		}
		
	}

	public void sendResponse(String me, Map<String,Object> map) {
		
	
	}
		


	
}
