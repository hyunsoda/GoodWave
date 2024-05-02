package edu.kh.goodWave.volunteer.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.goodWave.member.model.dto.Member;
import edu.kh.goodWave.volunteer.model.service.VolunteerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@SessionAttributes({"loginMember"})
@Controller
@RequestMapping("volunteer")
@RequiredArgsConstructor
@Slf4j
public class VolunteerController {

	private final VolunteerService service;
	
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
	public String donation(@RequestParam Map<String, Object> paramMap,
							@SessionAttribute("loginMember") Member loginMember,
							RedirectAttributes ra) {
		
		
		paramMap.put("memberNo", loginMember.getMemberNo() );
		
		
		
		int result = service.moneyDonation(paramMap);

		
		if(result > 0) {
			return "volunteer/donationComplete";
		} else {
			ra.addFlashAttribute("message","후원하기 실패");
			
			return "redirect:/volunteer/donation";
		}
		
		
		

		
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
