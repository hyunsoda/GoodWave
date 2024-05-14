package edu.kh.goodWave.mypage.controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.goodWave.donation.model.dto.Donation;
import edu.kh.goodWave.member.model.dto.Member;
import edu.kh.goodWave.mypage.model.service.MyPageService;
import edu.kh.goodWave.volunteer.model.dto.Volunteer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@SessionAttributes({ "loginMember" })
@Controller
@RequestMapping("mypage")
@RequiredArgsConstructor
@Slf4j
public class MyPageController {
	
	private final MyPageService service;
	
	/**마이 페이지 이동 및 수정화면으로 이동
	 * @return
	 */
	@GetMapping("mypage")
	public String mypage(@SessionAttribute("loginMember") Member loginMember , Model model ) {

		
		
		//주소만 꺼내옴
		String memberAddress = loginMember.getMemberAddress();
		
		log.info("memberAddress {}", memberAddress);
		
		// 주소가 있을 경우에만 동작
				if (memberAddress != null) {

					// 구분자 "^^^"를 기준으로
					// memberAddress 값을 쪼개어 String[]로 반환
					String[] arr = memberAddress.split("\\^\\^\\^"); // ^은 \\ 2개 붙여줘야한다.
																		// regex->정규표현식을 전달해야함

					
//					if(arr.length > 2) {
						model.addAttribute("postcode", arr[0]);
						model.addAttribute("address", arr[1]);
						model.addAttribute("detailAddress", arr[2]);
//					}
					
					
					// 05831^^^서울 송파구 동남로 99^^^201호^^^
					// ->["05831" , "서울 송파구 동남로 99","201호"]
					// [0] [1] [2]
//					model.addAttribute("postcode", arr[0]);
//					model.addAttribute("address", arr[1]);
					
					//model.addAttribute("detailAddress", arr[2]);
					
					//log.info("arr의 길이  {}", arr.length);
					//log.info("arr의 2번  {}" , arr[2]);
					
			}

		
		return "mypage/mypage";
	}
	
	/** 비밀번호 변경 화면으로 이동
	 * @return
	 */
	@GetMapping("passwordchange")
	public String passwordchange() {
		return "mypage/passwordchange";
	}
	
	/** 회원 탈퇴 화면 이동
	 * @return
	 */
	@GetMapping("withdrawal")
	public String withdrawal() {
		return "mypage/withdrawal";
	}
	
	
	
	
	/** 회원 정보 수정
	 * @param inputMember
	 * @param loginMember
	 * @param memberAddress
	 * @param ra
	 * @return redirect:info
	 */
	@PostMapping("mypage")
	public String updateInfo(Member inputMember, @SessionAttribute("loginMember") Member loginMember,
			@RequestParam("memberAddress") String[] memberAddress, RedirectAttributes ra) {
		
		// inputMember에 현재 로그인한 회원의 번호를 추가
		int memberNo = loginMember.getMemberNo();
		inputMember.setMemberNo(memberNo);
		
		// 회원 정보 수정 서비스 호출
		int result = service.updateInfo(inputMember, memberAddress);
		
		String message = null;
		
		if (result > 0) {
			message = "회원 정보 수정 성공!";

			// loginMember는
			// 세션에 저장된 로그인한 회원 정보가 저장된 객체를 참조하고 있다!!

			// -> loginMember 를 수정하면
			// 세션에 저장된 로그인한 회원정보가 수정된다!

			// ==세션 데이터와 DB 데이터를 맞춤

			loginMember.setMemberName(inputMember.getMemberName());

			loginMember.setMemberTel(inputMember.getMemberTel());

			loginMember.setMemberAddress(inputMember.getMemberAddress());

		} else {
			message = "회원 정보 수정 실패..";
		}

		ra.addFlashAttribute("message", message);

		return "redirect:/mypage";
		
	}
	
	/**
	 * 비밀번호 변경
	 * 
	 * @param paramMap    : 모든 파라미터를 맵으로 저장
	 * @param loginMember : 세션에 로그인한 회원 정보가 들어가 있음
	 * @param ra
	 * @return
	 */
	@PostMapping("passwordchange")
	public String changePw(@RequestParam Map<String, Object> paramMap,
			@SessionAttribute("loginMember") Member loginMember, RedirectAttributes ra) {

		// 로그인한 회원 번호
		int memberNo = loginMember.getMemberNo();

		// 현재 비밀번호 + 새 비밀번호 + 회원 번호를 서비스로 전달!
		int result = service.changePw(paramMap, memberNo);

		String path = null;
		String message = null;

		if (result > 0) {
			path = "/mypage/mypage";
			message = "비밀번호가 변경 되었습니다";
		} else {
			path = "/mypage/passwordchange";
			message = "현재 비밀번호가 일치하지 않습니다";
		}

		ra.addFlashAttribute("message", message);

		return "redirect:" + path;
	}
	
	
	/**
	 * 회원 탈퇴
	 * 
	 * @param memberPw    : 입력 받은 비밀번호
	 * @param loginMember : 로그인한 회원의 정보를 얻어옴(세션에 담겨있음)
	 * @param status      : 세션 완료 용도의 객체 -> @SessionAttributes 로 등록된 세션을 완료
	 * @param ra          :
	 * @return
	 */
	@PostMapping("withdrawal")
	public String secession(@RequestParam("memberPw") String memberPw,
			@SessionAttribute("loginMember") Member loginMember, SessionStatus status, RedirectAttributes ra) {

		// 서비스 호출
		int memberNo = loginMember.getMemberNo();

		int result = service.secession(memberPw, memberNo);

		String message = null;
		String path = null;

		if (result > 0) {
			message = "탈퇴 되었습니다";
			path = "/";

			status.setComplete(); // 세션을 완료시킴

		} else {
			message = "비밀번호가 일치하지 않습니다";
			path = "withdrawal";

		}

		ra.addFlashAttribute("message", message);

		return "redirect:/" + path;
	}

	@ResponseBody
	@GetMapping("applyList")
	public List<Volunteer> applyList(@SessionAttribute("loginMember") Member loginMember){
		
		int memberNo = loginMember.getMemberNo();
		
		List<Volunteer> applyList = service.applyList(memberNo);
				
		
		return applyList;
	}
	
	@ResponseBody
	@GetMapping("donationList")
	public List<Donation> donationList(@SessionAttribute("loginMember") Member loginMember){
		
		int memberNo = loginMember.getMemberNo();
		
		List<Donation> re = service.selectDonationList(memberNo);
				
		return  re;
		
	}
	
//	/**
//	 * 신청 취소
//	 * 
//	 * @return
//	 */
	@ResponseBody
	@PostMapping("applyCancle")
	public int cancle(@RequestBody Volunteer volunteer, 
					@SessionAttribute("loginMember") Member loginMember
) {
		
		
		
//		@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date
//		String  applyCancleDate = date.toString();
		
		log.info("volunteerNo : " + volunteer.getVolunteerNo());
		
		volunteer.setMemberNo(loginMember.getMemberNo());
		
		return service.cancle(volunteer);
	}


	
	
	
}
