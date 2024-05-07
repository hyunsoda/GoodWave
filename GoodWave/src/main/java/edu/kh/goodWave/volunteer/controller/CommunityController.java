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
	
	@GetMapping("QNA")
	public String QNA() {
		return "/community/qnaboard";
	}
	
	@GetMapping("QNAwrite")
	public String QNAwrite() {
		return "/community/QNAwrite";
	}
	
	@GetMapping("Comment")
	public String Comment() {
		return "/community/Comment";
	}
	
	@GetMapping("QNAupdate")
	public String QNAupdate() {
		return "/community/QNAupdate";
	}
	
}
