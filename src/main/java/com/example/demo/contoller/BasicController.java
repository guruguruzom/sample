package com.example.demo.contoller;

import java.time.LocalDateTime;
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

import com.example.demo.vo.UserVo;

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
	 */
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
	
	/*
	 * 기본 object  
	 */
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
	
	/*
	 * date time 
	 */
	@GetMapping("/date")
	public String date(Model model) {
		model.addAttribute("localDateTime", LocalDateTime.now());
		
		return "basic/date";
	}
	
	/*
	 * url link 
	 */
	@GetMapping("/link")
	public String link(Model model) {
		model.addAttribute("param1", "data1");
		model.addAttribute("param2", "data2");
		
		return "basic/link";
	}
	
	/*
	 * literal
	 */
	@GetMapping("/literal")
	public String literal(Model model) {
		model.addAttribute("data", "Spring!");
		
		return "basic/literal";
	}
	
	/*
	 * operation
	 */
	@GetMapping("/operation")
	public String operation(Model model) {
		model.addAttribute("nullData", null);
		model.addAttribute("data", "Spring!");
		
		return "basic/operation";
	}
	
	/*
	 * tag attribute
	 */
	@GetMapping("/attribute")
		public String attribute() {
		return "basic/attribute";
	}
	
	/*
	 * for each문
	 */
	@GetMapping("/each")
	public String each(Model model) {
		//method 내에 model을 세팅해도 추가됨
		addUsers(model);
		return "basic/each";
	}
	private void addUsers(Model model) {
		List<UserVo> list = new ArrayList<>();
		list.add(new UserVo("userA", 10));
		list.add(new UserVo("userB", 20));
		list.add(new UserVo("userC", 30));
		model.addAttribute("users", list);
	}
	
	/*
	 * 조건문
	 */
	@GetMapping("/condition")
	public String condition(Model model) {
		addUsers(model);
		return "basic/condition";
	}
	
	/*
	 * 주석 
	 */
	@GetMapping("/comments")
	public String comments(Model model) {
		model.addAttribute("data", "Spring!");
		return "basic/comments";
	}
	
	/*
	 * 블록
	 * */
	@GetMapping("/block")
	public String block(Model model) {
		addUsers(model);
		return "basic/block";
	}
	
	/*
	 * 자바스크립트
	 * */
	@GetMapping("/javascript")
	public String javascript(Model model) {
		model.addAttribute("user", new UserVo("userA", 10));
		addUsers(model);
		return "basic/javascript";
	}
}
