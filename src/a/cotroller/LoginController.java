package a.cotroller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import a.service.LoginService;

@Controller
@RequestMapping
public class LoginController {
	@Autowired
	LoginService login;
	
	@RequestMapping(path="login", method=RequestMethod.GET)
	public String loginGetHandle() {
		
		
		return "login";
	}
	
	@RequestMapping(path="login", method=RequestMethod.POST)
	public String loginPostHandle(@RequestParam Map map,Model model) {
		boolean rst = login.loginBy(map);
		
		return "index";
	}
	
}