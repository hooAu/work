package a.cotroller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import a.service.MailService;

@Controller
public class AuthController {
	@Autowired
	MailService mail;
	
	
	
	@RequestMapping(path="auth", method=RequestMethod.POST)
	public void authHandle(HttpSession session) {
		String id = (String)session.getAttribute("logon");
		String addr = mail.getMail(id);
		
		
	}
	
	
}
