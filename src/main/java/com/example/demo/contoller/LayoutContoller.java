package com.example.demo.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/template")
public class LayoutContoller {
	@GetMapping("/layout")
	public String template() {
		return "layout/layoutMain";
	}
	
	@GetMapping("/layoutExtend")
	public String layoutExtends() {
	return "layout/layoutExtendMain";
	}
}
