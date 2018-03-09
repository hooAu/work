package a.cotroller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import a.service.JoinService;

@Controller
@RequestMapping
public class JoinController {
	@Autowired
	JoinService join;
	
	@RequestMapping(path="/join", method=RequestMethod.GET)
	public String joinHandle() {
		
		return "join";
	}
	
	@RequestMapping(path="/join", method=RequestMethod.POST)
	public String joinPostHandle(@RequestParam Map map,HttpSession session, Model model) {
		Map rst = new HashMap<>();
		try {
			rst = join.register(map);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		if(!rst.containsKey("id") && !rst.containsKey("mail")) {
			session.setAttribute("logon", map.get("id"));
			return "redirect:/index";
		} else {
			model.addAttribute(rst);
			return "join";
		}
	}
	
	@RequestMapping(path="/mailChk",produces="application/json;charset=utf-8")
	@ResponseBody
	public String joinAjax(@RequestParam String mail) {
		
		
		return "";
	}
	
		
		
}
