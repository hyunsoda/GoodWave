package edu.kh.goodWave.volunteer.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.goodWave.member.model.dto.Member;
import edu.kh.goodWave.volunteer.model.dto.Volunteer;
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
	public String talentDonation(@RequestParam Map<String, Object> paramMap,
			@SessionAttribute("loginMember") Member loginMember,
			RedirectAttributes ra) {
		
	paramMap.put("memberNo", loginMember.getMemberNo());
		
		int result = service.talent(paramMap);
		
		if(result >0) {
			return "volunteer/talentComplete";
		} else {
			ra.addFlashAttribute("message","다시 신청해주세요");
			return "redirect:/volunteer/talent"; 
		}
		
	}
	
		
	
	/** 연탄봉사
	 * @return
	 */
	@GetMapping("yeontan")
	public String yeontan() {
		
		return "volunteer/yeontan";
	}
	
	@PostMapping("yeontan")
	public String yeontan(@RequestParam Map<String, Object> paramMap,
							@SessionAttribute("loginMember") Member loginMember,
							RedirectAttributes ra) {
		
		paramMap.put("memberNo", loginMember.getMemberNo());
		
//		DateTimeFormatter formatter  = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//		String yeontanDate2 = yeontanDate.format(formatter);
//		Volunteer volunteer = new Volunteer();
		
//		volunteer.setMemberNo(loginMember.getMemberNo());
//		volunteer.setYeontanDate(yeontanDate2);
		
//		Map<String, Object> yeontanMap = new HashMap<>();
//		yeontanMap.put("yeontanDate", yeontanDate);
//		yeontanMap.put("memberNo", loginMember.getMemberNo());
//		yeontanMap.put("yeontanName", yeontanName);
//		yeontanMap.put("yeontanTel", yeontanTel);
		
		
		int result = service.yeontan(paramMap);
		
		if(result >0) {
			return "volunteer/yeontanComplete";
		} else {
			ra.addFlashAttribute("message","다시 신청해주세요");
			return "redirect:/volunteer/yeontan"; 
		}
		
		
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
	public String visit(@RequestParam Map<String, Object> paramMap,
			@SessionAttribute("loginMember") Member loginMember,
			RedirectAttributes ra) {
		
		paramMap.put("memberNo", loginMember.getMemberNo());
		
		int result = service.visit(paramMap);
		
		if(result >0) {
			return "volunteer/visitComplete";
		} else {
			ra.addFlashAttribute("message","다시 신청해주세요");
			return "redirect:/volunteer/visit"; 
		}
		
	}
	
	
}
