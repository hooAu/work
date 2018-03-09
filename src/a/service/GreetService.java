package a.service;

import org.springframework.stereotype.Service;

@Service
public class GreetService {
	
	public String make() {
		String[] ments = "안녕하세요,HELLO".split(",");
		
		return ments[(int)(Math.random()*ments.length)];
	}
}
