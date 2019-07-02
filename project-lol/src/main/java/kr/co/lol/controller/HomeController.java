package kr.co.lol.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/home.lol")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/detail.lol")
	public String detail() {
		return "detail";
	}
}
