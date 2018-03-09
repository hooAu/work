package a.service;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
	@Autowired
	SqlSessionTemplate template;
	
	public boolean loginBy(Map map) {
		boolean chk = false;
		Map rst = template.selectOne("member.loginByIdOrMail",map);
		if(rst != null) 
			chk = true;
		
		
		return chk;
	}
	
	
}
