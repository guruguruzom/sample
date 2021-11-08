package com.example.demo.contoller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vo.UserVo;

@Controller
@RequestMapping("/basic")
public class BasicController {
	//타임리프 텍스트 출력 [[$....]]
	@GetMapping("/text-basic")
	public String textBasic(Model model) {
		//HttpServletRequest request -> request.setAttribute
		model.addAttribute("data", "Hello Spring!");
	 
		return "basic/text-basic";
	}

	//이스케이프 미사용
	/*
	 * th:text -> th:utext
	 * [[...]] -> [(...)]
	 * */
	@GetMapping("/text-unescaped")
	public String textUnescaped(Model model) {
		model.addAttribute("data", "Hello <b>Spring!</b>");
		System.out.println("test");
		// return String 에 unescaped 포함시 못찾는 문제 발생
		return "basic/text-unes";
	}
	
	
	@GetMapping("/variable")
	public String variable(Model model) {
		UserVo userA = new UserVo("userA", 10);
		UserVo userB = new UserVo("userB", 20);
		List<UserVo> list = new ArrayList<>();
		list.add(userA);
		list.add(userB);
		Map<String, UserVo> map = new HashMap<>();
		map.put("userA", userA);
		map.put("userB", userB);
		model.addAttribute("user", userA);
		model.addAttribute("users", list);
		model.addAttribute("userMap", map);
		return "basic/variable";
	}
	
	//session test
	@GetMapping("/basic-objects")
	public String basicObjects(HttpSession session) {
	session.setAttribute("sessionData", "Hello Session");
	return "basic/basic-objects";
	}
	
	@Component("helloBean")
	static class HelloBean {
		public String hello(String data) {
			return "Hello " + data;
		}
	}
}
