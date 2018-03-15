package a.cotroller;

import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import a.service.MailService;

@Controller
public class AuthController {
	@Autowired
	MailService mail;
	
	@RequestMapping(path="/auth", method=RequestMethod.POST)
	public void authHandle(HttpSession session) {
		String id = (String)session.getAttribute("logon");
		String addr = mail.getMail(id);
		String authKey = UUID.randomUUID().toString().substring(0, 6);
		
		boolean rst = mail.sendAuthKey(addr,authKey);
		// 여기선 인증키를 세션에 담아서 보내지만, 프로젝트 진행할 경우에는
		// 데이터베이스 테이블을 하나 만들어서 그곳에 저장하자. 
		session.setAttribute("key", authKey);
		session.setAttribute("sendRst",rst);
		
	}
	
	
}
