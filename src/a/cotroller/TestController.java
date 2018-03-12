package a.cotroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import a.service.MailService;

@Controller
public class TestController {
	@Autowired
	MailService mail;
	
	@RequestMapping("/test/email")
	public void testHandle(@RequestParam String target) {
		boolean rst = mail.sendWelcomeMail(target);
		System.out.println("메일 전송 결과 : " + rst);
	}
}
