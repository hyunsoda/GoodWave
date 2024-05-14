package edu.kh.goodWave.member.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.goodWave.member.model.dto.Member;
import edu.kh.goodWave.member.model.service.MemberService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@SessionAttributes({"loginMember"})
@Slf4j
@Controller
@RequestMapping("member")
public class MemberController {

	@Autowired
	private MemberService service;
	
	// Bcrpt 암호화 객체 의존성 주입 (SecurityConfig 참고)
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
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
						Model model,
						@RequestParam(value="saveId", required=false) String saveId,
						HttpServletResponse resp) {
		
		log.info("inputMember {}", inputMember);
		Member loginMember = service.loginMember(inputMember);
		
		// 회원 정보 없을때 
		if(loginMember == null ) {
			ra.addFlashAttribute("message","아이디 혹은 비밀번호를 확인해주세요");
			return "redirect:/member/login";
		}
		
		// 회원 정보 있을때
		model.addAttribute("loginMember",loginMember);
		
		Cookie cookie = new Cookie("saveId", loginMember.getMemberId());
		
		
		//saveId=user01
		
		cookie.setPath("/");
		
		if(saveId != null) {
			cookie.setMaxAge(60 * 60 * 24 * 30);
		}else {
			cookie.setMaxAge(0);
		}
		
		resp.addCookie(cookie);
		
		ra.addFlashAttribute("message","로그인되었습니다.");
		
	
		
		return "redirect:/";
	}
	
	@GetMapping("signUp")
	public String signup() {
		return "member/signUp";
	}
	
	/** 맴버 회원가입
	 * @param inputMember
	 * @param member
	 * @param ra
	 * @return
	 */
	@PostMapping("signUp")
	public String signUp(
			Member inputMember,
			@RequestParam(value="memberAddress", required=false) String[] member,
			RedirectAttributes ra
			) {
		
		
		System.out.println(inputMember);
		
		int result = service.signup(inputMember,member);
		
		String path = "";
		String message = "";
		
		if(result > 0) {
			path = "member/signUpComplete";
		}else {
			message = "회원가입 실패";
			ra.addFlashAttribute("message", message);
			path = "redirect:/";
		}
		
		
		
		return path;
	}
	
	/** 맴버 이메일 중복확인검사
	 * @param email
	 * @return
	 */
	@ResponseBody
	@GetMapping("emailCheck")
	public int emailCheck(
			@RequestParam("memberEmail") String email
			) {
		int result = service.checkEmail(email);
		
		return result;
	}

	@GetMapping("idSearch")
	public String idSearch() {
		
		
		return "member/idSearch";
	}
	
	
	@PostMapping("idSearch")
	public String idSearch(@RequestParam Map<String, String> paramMap,
							Model model,
							RedirectAttributes ra) {
		
		String id = service.idSearch(paramMap);
		
		if(id == null) {
			ra.addFlashAttribute("message", "일치하는 회원 정보가 없습니다.");
			return "redirect:/member/idSearch";
		} else {
			model.addAttribute("searchName",paramMap.get("searchName"));
			model.addAttribute("id",id);
			return "member/idSearchComplete";
		}
		
		
		
	}
	
	@GetMapping("pwSearch")
	public String pwSearch() {
		
		return "member/pwSearch";
	}
	

	@GetMapping("logout")
	public String logout(
			
			SessionStatus loginMember,
			RedirectAttributes ra
			) {
				loginMember.setComplete();
				ra.addFlashAttribute("message", "로그아웃 되었습니다");
				
				return "redirect:/";
		
	}
	


	

	@PostMapping("pwSearch")
	public String pwSearch(@RequestParam Map<String, String> paramMap,
							RedirectAttributes ra,
							Model model) {
		
		String pw = service.pwSearch(paramMap);
		
		if(pw != null) {
			model.addAttribute("searchName",paramMap.get("search2Name"));
			return "member/pwSearchComplete";
		}
		
		ra.addFlashAttribute("message","일치하는 회원 정보가 없습니다.");
		return "redirect:/member/pwSearch";
		
	}


	
}
