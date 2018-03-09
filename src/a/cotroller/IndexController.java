package a.cotroller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import a.service.GreetService;

@Controller
public class IndexController {
	@Autowired
	GreetService greet;
	
	@RequestMapping({"/","index"})
	public String aHandle(Map map) {
		map.put("hello", greet.make());
		
		return "index";
	}
}
