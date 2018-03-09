package a.cotroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping
public class ChatController {
	
	
	@RequestMapping(path="/chat", method=RequestMethod.GET)
	public String chatGetHandle() {
		
		
		return "makeChat";
	}
}
