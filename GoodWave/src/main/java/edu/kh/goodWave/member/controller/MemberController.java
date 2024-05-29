package edu.kh.goodWave.member.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.goodWave.member.model.dto.Member;
import edu.kh.goodWave.member.model.service.MemberService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;



@SessionAttributes({"loginMember"})
@Slf4j
@Controller
@RequestMapping("member")
@PropertySource("classpath:/config.properties")
public class MemberController {

	@Autowired
	private MemberService service;
	
	
    @Value("${naver.client_id}")
    private String naverClientId;
    
    @Value("${naver.redirect_uri}")
    private String naverRedirectUri;
    
    @Value("${naver.client_secret}")
    private String naverClientSecret;
	
	// Bcrpt 암호화 객체 의존성 주입 (SecurityConfig 참고)
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	
	
	@RequestMapping("/naver_login")
	public String naver_login(HttpServletRequest request, Model model, HttpServletRequest request2) {
	
		String login_url = service.loginUrl(model,request2);
		
	
	    return "redirect:" + login_url;
	}
	
	@RequestMapping("/naverCallback")
	public String naver_redirect(HttpServletRequest request, Model model,RedirectAttributes ra) {
		// 네이버에서 전달해준 code, state 값 가져오기
	    String code = request.getParameter("code");
	    String state = request.getParameter("state");

	    
	     //세션에 저장해둔 state값 가져오기
	    String session_state = "state";

		// CSRF 공격 방지를 위해 state 값 비교
//	    if (!state.equals(session_state)) {
//	        System.out.println("세션 불일치");
//	        request.getSession().removeAttribute("state");
//	        return "/error";
//	    }

	    String tokenURL = "https://nid.naver.com/oauth2.0/token";
	    
	 

	    // body data 생성
	    MultiValueMap<String, String> parameter = new LinkedMultiValueMap<>();
	    parameter.add("grant_type", "authorization_code");
	    parameter.add("client_id", naverClientId);
	    parameter.add("client_secret", naverClientSecret);
	    parameter.add("code", code);
	    parameter.add("state", state);

	    log.info(parameter.toString());
	    
	    // request header 설정
	    HttpHeaders headers = new HttpHeaders();
	    
	    // Content-type을 application/x-www-form-urlencoded 로 설정
	    headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
//	   headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//	    headers.set("header-key", "HttpHeaders");
	    
	    // header 와 body로 Request 생성
	    HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(parameter,headers);
	    log.debug("엔티티확인!!!! " +entity);
	    
	    try {
	        RestTemplate restTemplate = new RestTemplate();
	        // 응답 데이터(json)를 Map 으로 받을 수 있도록 관련 메시지 컨버터 추가
	        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());

	        // Post 방식으로 Http 요청
	        // 응답 데이터 형식은 Hashmap 으로 지정
	        ResponseEntity<HashMap> result = restTemplate.postForEntity(tokenURL, entity, HashMap.class);
	        log.debug("abagjdiofhad;fadskfsa d s   "+result);
	        
	       
			Map<String, String> resMap = result.getBody();
	        
	        
	        
	        
	        // 리턴받은 access_token 가져오기
	        String access_token = resMap.get("access_token");


			    
	        
	        
	        String userInfoURL = "https://openapi.naver.com/v1/nid/me";
	        // Header에 access_token 삽입
	        headers.set("Authorization", "Bearer "+access_token);

	        // Request entity 생성
	        HttpEntity<?> userInfoEntity = new HttpEntity<>(headers);

	        // Post 방식으로 Http 요청
	        // 응답 데이터 형식은 Hashmap 으로 지정
	        ResponseEntity<HashMap> userResult = restTemplate.postForEntity(userInfoURL, userInfoEntity, HashMap.class);
	        Map<String, Map<String, Object>> userResultMap = userResult.getBody();

	        //응답 데이터 확인
	        log.debug("확인!!!!!!!!!!!!!!!!!!!!"+userResultMap.toString());
	        
	        log.info(userResultMap.get("response").get("email").toString());

	        Member inputMember = new Member();
	        
	        int emailResult = service.checkEmail(userResultMap.get("response").get("email").toString());
	        
	        inputMember.setMemberEmail(userResultMap.get("response").get("email").toString());
	        inputMember.setMemberId(userResultMap.get("response").get("id").toString());
	        inputMember.setMemberName(userResultMap.get("response").get("nickname").toString());
		        
	        String PhoneNumber = (userResultMap.get("response").get("mobile").toString()).replaceAll("-", "");
	        inputMember.setMemberTel(PhoneNumber);
	        
	        log.debug("멤버확이니인이닝" + inputMember);
	        log.debug("멤버확이니인이닝" + emailResult);
	        
	        if(emailResult == 0) {
	        	
		        int signUpNaverResult = service.signUpNaver(inputMember);
		        
				if(signUpNaverResult <1) {
				
					String message = "회원가입 실패";
					ra.addFlashAttribute("message", message);
					return "redirect:/";
				} 
		        
	        }
	        	
		        Member loginMember = service.loginMember(inputMember);
		        model.addAttribute("loginMember",loginMember);
	        
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

			// 세션에 저장된 state 값 삭제
	    request.getSession().removeAttribute("state");
	    
	   
	    
	    
	    return "redirect:/";
	}
	
	
	
	/** 로그인 페이지 이동
	 * @return
	 */
	@GetMapping("login")
	public String login(Model model) {
		
	
		
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
	
	@ResponseBody
	@GetMapping("checkMemberId")
	public int checkMemberId(
			@RequestParam("memberId") String memberId
			) {
		return service.checkMemberId(memberId);
	}


	
}
