package edu.kh.goodWave.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("volunteer")
public class VolunteerController {

	
	
	/** 재능 기부
	 * @return
	 */
	@GetMapping("talentDonation")
	public String talentDonation() {
		
		return "volunteer/talentDonation";
	}
	
	@PostMapping("talentDonation")
	public String talentDonation(@RequestParam("name") String name ) {
		
		return "volunteer/talentDonationComplete";
	}
	
	
	/** 연탄봉사
	 * @return
	 */
	@GetMapping("yeontan")
	public String yeontan() {
		
		return "volunteer/yeontan";
	}
	
	@PostMapping("yeontan")
	public String yeontan(@RequestParam("name") String name) {
	
		return "volunteer/yeontanComplete";
	}
	
	
	/** 후원하기
	 * @return
	 */
	@GetMapping("donation")
	public String donation() {
		
		return "volunteer/donation";
	}
	
	
	@PostMapping("donation")
	public String donation(@RequestParam("donationName") String donationName) {
		
		
		return "volunteer/donationComplete";
		
	}
	
	/** 방문봉사 하기
	 * @return
	 */
	@GetMapping("visit")
	public String visit() {
	
		return "volunteer/visit";
	}
	
	@PostMapping("visit")
	public String visit(@RequestParam("name") String name) {
		
		
		return "volunteer/visitComplete";
	}
	
	
}
