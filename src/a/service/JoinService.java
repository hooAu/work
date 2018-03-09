package a.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JoinService {
	@Autowired
	SqlSessionTemplate template;
	
	
	public Map register(Map map) throws Exception {
		Map rst = new HashMap<>();
		map.put("lv", 0);
		int r = template.insert("member.insertOne", map);
		if(r!=1) {
			List<Map> id = template.selectList("member.checkId", (String)map.get("id"));
			List<Map> mail = template.selectList("member.checkMail", (String)map.get("mail"));
			if(!id.isEmpty()) {
				rst.put("id", "이미 존재하는 ID 입니다.");
			} 
			if(!mail.isEmpty()) {
				rst.put("mail", "이미 존재하는 e-mail 입니다.");
			}
		}
		
		
		
		return rst;
	}
	
}
