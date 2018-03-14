package a.cotroller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import a.service.FollowService;
import a.service.MessageService;

@Controller
public class FollowController {
	@Autowired
	FollowService follow;
	@Autowired
	MessageService message;
	
	@RequestMapping(path="/follow",method=RequestMethod.GET)
	public String followGetHandle(Model model) {
		List<Map> list = follow.getMember();
		model.addAttribute("follow", list);
		return "follow";
	}
	
	@RequestMapping(path="/follow",method=RequestMethod.POST)
	public String followPostHandle(@RequestParam String target,HttpSession session,Model model) {
		System.out.println(target);
		model.addAttribute("target", target);
		String me = (String)session.getAttribute("logon");
		
		boolean rst = false;
		try {
			rst = follow.addFollow(target,me);
			message.sendRequest(me,target);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("followRst",rst);
		
		return "followp";
	}
	
	@RequestMapping(path="/flist",method=RequestMethod.GET)
	public String flistGetHandle(Model model,HttpSession session) {
		String me = (String)session.getAttribute("logon");
		List<Map> list = follow.getRequest(me);
		model.addAttribute("req", list);
		
		return "flist";
	}
	
	@RequestMapping(path="/flist",method=RequestMethod.POST)
	public String flistPostHandle(@RequestParam Map param,HttpSession session, Model model) {
		String me = (String)session.getAttribute("logon");
		System.out.println(param);
		
		try {
			follow.sendResp(param,me);
			message.sendResponse(me,param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return "";
	}
	
	
	
	
	
	
}
