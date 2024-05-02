package edu.kh.goodWave.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.goodWave.member.model.dto.Member;
import edu.kh.goodWave.member.model.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@SessionAttributes({"loginMember"})
@Slf4j
@Controller
@RequestMapping("member")
public class MemberController {

	@Autowired
	private MemberService service;
	
	/** 로그인 페이지 이동
	 * @return
	 */
	@GetMapping("login")
	public String login() {
		
		return "member/login";
	}
	
	/** 로그인 하기
	 * @param inputMember
	 * @return
	 */
	@PostMapping("login")
	public String login(Member inputMember,
						RedirectAttributes ra,
						Model model) {
		
		
		Member loginMember = service.loginMember(inputMember);
		
		if(loginMember == null ) {
			ra.addFlashAttribute("message","아이디 혹은 비밀번호를 확인해주세요");
			return "redirect:/member/login";
		}
		if(loginMember != null) {
			model.addAttribute("loginMember",loginMember);
			ra.addFlashAttribute("message","로그인되었습니다.");
		}
		
		
		
		return "redirect:/";
	}
	
	@GetMapping("signUp")
	public String signup() {
		return "member/signUp";
	}
	
	@PostMapping("signUp")
	public String signUp() {
		return "member/signUpComplete";
	}

	@GetMapping("idSearch")
	public String idSearch() {
		
		return "member/idSearch";
	}
	
	@GetMapping("pwSearch")
	public String pwSearch() {
		
		return "member/pwSearch";
	}
	
	
	
	
}
