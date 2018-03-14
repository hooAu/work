package a.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FollowService {
	@Autowired
	SqlSessionTemplate template;
	
	public List getMember() {
		
		return template.selectList("member.selectAll");
	}

	public boolean addFollow(String target,String me) {
		Map map = new HashMap<>();
			map.put("one", me);
			map.put("other", target);
		int rst = template.insert("friend.insertOne", map);
		
		return rst == 1;
	}

	public List<Map> getRequest(String me) {
		Map map = new HashMap<>();
			map.put("other",me);
		
		return template.selectList("friend.getRequest",map);
	}

	
	public void sendResp(Map req,String me) {
		Map map = new HashMap<>();
		
		for(Object o : req.keySet()) {
			map.put("one", String.valueOf(o));
			String s = String.valueOf(req.get(o));
			if(s.equals("accept")) {
				map.put("status",1);
			} else {
				map.put("status", 0);
			}
			map.put("other", me);
			template.update("friend.updateStatus", map);
		}
	}
		
	

	
		
		
		
		


		
	
}
