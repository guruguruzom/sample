package com.example.demo.contoller;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexControllor {
	
	@GetMapping(value = {"", "/"})
	public String indexTest(HttpServletRequest request) {
		return "index";
	}

}
