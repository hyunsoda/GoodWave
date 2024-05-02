package edu.kh.goodWave.volunteer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("community")
public class CommunityController {


	@GetMapping("FAQ")
	public String FAQ() {
		
		return "/community/FAQ";
	}
	
	
}
