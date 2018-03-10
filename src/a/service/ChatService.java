package a.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatService {
	@Autowired
	SqlSessionTemplate template;
	
	public int checkAuth(String id) {
		
		return template.selectOne("member.checkAuth", id);
	}
}
