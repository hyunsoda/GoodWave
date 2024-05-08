package edu.kh.goodWave.introduce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("introduce")
public class IntroduceController {
	
	// 소개 페이지로 forward
	@GetMapping("introduce")
	public String introduce() {
		return "introduce/GoodWave_introduce";
	}
	
	// 정신 페이지로 forward
	@GetMapping("mental")
	public String mental() {
		return "introduce/GoodWave_mental";
	}
	
	
	//인사말 페이지로 forward
	@GetMapping("greeting")
	public String greeting() {
		return "introduce/GoodWave_greeting";
	}
}
