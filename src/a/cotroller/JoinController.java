package a.cotroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import com.google.gson.Gson;

import a.service.JoinService;

@Controller
@RequestMapping
public class JoinController {
	@Autowired
	JoinService join;
	@Autowired
	Gson gson;
	@Autowired
	Map<String,List<WebSocketSession>> ws;
	
	
	@RequestMapping(path="/join", method=RequestMethod.GET)
	public String joinHandle() {
		
		return "join";
	}
	
	@RequestMapping(path="/join", method=RequestMethod.POST)
	public String joinPostHandle(@RequestParam Map map,HttpSession session, Model model) {
		boolean rst = false;
		try {
			rst = join.register(map);
			if(rst) {
				session.setAttribute("logon", map.get("id"));
				// 웹소켓으로 다른탭에 알리는 코드
				String sid = session.getId();			
				List<WebSocketSession> list = ws.get(sid);
				Map data = new HashMap<>();
					data.put("login", "다른 탭에서 로그인이 되었습니다.\n새로고침 해주세요.");
				if(list != null) {
					for(WebSocketSession ws : list) {
						try {
							ws.sendMessage(new TextMessage(gson.toJson(data)));
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
				return "redirect:/index";
			}
			throw new Exception();
		} catch (Exception e) {
			e.printStackTrace();
			Map error =	join.errorChk(map);
			model.addAttribute("error",error);
			
			return "join";
		} 
	}
				
				
				

		
	
	@RequestMapping(path="/mailChk",produces="application/json;charset=utf-8")
	@ResponseBody
	public String mailAjax(@RequestParam String mail) {
		Map map = new HashMap<>();
		
		String regex = ("[a-zA-Z]+[0-9]*(\\.)?[a-zA-Z]*@[a-z]+\\.[a-zA-Z]+");
		if(mail.matches(regex)) {
			map.put("pattern",true);
		} else {
			map.put("pattern", false);
		}
		
		boolean rst = join.mailChk(mail);
			map.put("chk", rst);
		
		return gson.toJson(map);
	}
	
	@RequestMapping(path="/idChk",produces="application/json;charset=utf-8")
	@ResponseBody
	public String idAjax(@RequestParam String id) {
		Map map = new HashMap<>();
		
		String regex = "[a-zA-Z]+";
		if(id.matches(regex)) {
			map.put("p", true);
		} else {
			map.put("p", false);
		}
		
		boolean rst = join.idChk(id);
			map.put("chk", rst);
		
		return gson.toJson(map);
	}
	
		
		
}
