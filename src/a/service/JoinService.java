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
	
	
	public boolean register(Map map)  {
		Map rst = new HashMap<>();
			map.put("lv", 0);
		int r = template.insert("member.insertOne", map);
		/*
		 * selectList로 뽑을 경우, null로 체크할 수 없다.
		 * 이유는 List가 무조건 만들어지기 때문이다. 이 경우, size가 0이냐 아니냐로 체크해야 한다.
		 * 
		 */
		
		return r==1 ;
			
	}
	
	public Map errorChk(Map map) {
		Map error = new HashMap<>();
		
		Map id = template.selectOne("member.checkId", (String)map.get("id"));
		Map mail = template.selectOne("member.checkMail", (String)map.get("mail"));
		if(id != null)
			error.put("id", "이미 존재하는 ID 입니다.");
		if(mail != null)	
			error.put("mail", "이미 존재하는 e-mail 입니다.");
		
		return error;
	}
		
			
		 
			
		
		
		
	
}
