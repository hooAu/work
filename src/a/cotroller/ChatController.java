package a.cotroller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import a.service.ChatService;

@Controller
@RequestMapping
public class ChatController {
	@Autowired
	ChatService chat;
	
	@RequestMapping(path="/chat", method=RequestMethod.GET)
	public String chatGetHandle() {
		
		
		return "chat";
	}
	
	
	@RequestMapping(path="/chat",method=RequestMethod.POST )
	public String chatPostHandle(@RequestParam Map map,HttpSession session) {
		String id = (String)session.getAttribute("logon");
		System.out.println(id);
		String rst = chat.checkAuth(id);
		System.out.println(rst);
		if(rst.equals("0")) {
			return "redirect:/index";
		} else {
			return "redirect:/chat";
		}
		
		
	}
}
