package a.service;

import java.util.UUID;

import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	@Autowired
	JavaMailSender mailSender;
	
	public boolean sendWelcomeMail(String target) {
		MimeMessage message = mailSender.createMimeMessage();
		try {	
			// 받을 사람
			message.setRecipient(RecipientType.TO , new InternetAddress(target) );
			// 보내는 사람 - google 서버같은 경우는 이설정을 무시한다.
			message.setFrom(new InternetAddress("administrator@spring.io"));
			
			// 제목
			message.setSubject("[SpringIo] 가입을 축하드립니다.");
			
			// 내용 
			// content 설정을 text/html;charset=utf-8 이라고 보내면, html로 보낼수도 있다.
			String content = "가입을 축하드립니다.<br/>사용에 불편하신 점이 있으면 고객센터로 연락주세요.";
				content += "인증번호 : " + UUID.randomUUID().toString().substring(0, 6);
				content += "<br/><a href=\"192.168.10.66/\" style=\"text-decoration:none;\">인증페이지 가기</a>";
			message.setContent(content, "text/html;charset=utf-8");
			
			mailSender.send(message);
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public String getMail(String id) {
		
		return "";
	}
	
	
	
	
	
}
