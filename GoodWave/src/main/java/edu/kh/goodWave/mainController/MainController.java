package edu.kh.goodWave.mainController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/")
	public String mainPage() {
		
		return "common/main";
		
	}
	
	@GetMapping("mypage/mypage")
	public String myPage() {
		return "mypage/mypage";
	}
}
