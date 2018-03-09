package a.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatService {
	@Autowired
	SqlSessionTemplate template;
	
	public String checkAuth(String id) {
		String rst = template.selectOne("member.checkAuth", id);
		return rst;
	}
}
