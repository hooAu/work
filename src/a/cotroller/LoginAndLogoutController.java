package a.cotroller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.socket.WebSocketSession;

import a.service.LoginService;

@Controller
@RequestMapping
public class LoginAndLogoutController {
	@Autowired
	LoginService login;
	
	@RequestMapping(path="/login", method=RequestMethod.GET)
	public String loginGetHandle() {
		
		
		return "login";
	}
	
	@RequestMapping(path="/login", method=RequestMethod.POST)
	public String loginPostHandle(@RequestParam Map map,Model model,HttpSession session) {
		boolean rst = login.loginBy(map);
		if(rst) {
			session.setAttribute("logon", (String)map.get("id"));
			
			// 로그인 하거나 로그아웃 할 경우, 같은 브라우저로 접근한 사용자에게 알림 띄우기.
			// webSocket을 어떤식으로 접근할 것인지?
			// 웹소켓 컨트롤러에 등록된 map을 bean으로 등록하고, wired 받아서 사용하자.
						
		}
		
		return "index";
	}
	
	@RequestMapping("/logout")
	public String logoutHandle(HttpSession session) {
		session.removeAttribute("logon");
		
		return "index";
	}
	
}