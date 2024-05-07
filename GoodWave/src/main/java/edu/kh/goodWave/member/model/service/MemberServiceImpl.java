package edu.kh.goodWave.member.model.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
//import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.spring6.SpringTemplateEngine;

import edu.kh.goodWave.member.model.dto.Member;
import edu.kh.goodWave.member.model.mapper.MemberMapper;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

//@Transactional(rollbackFor=Exception.class)
@Service
@Slf4j
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

	private final MemberMapper mapper;
	
	private final BCryptPasswordEncoder bcrypt;
	
	private final JavaMailSender mailSender;
	
	private final SpringTemplateEngine templateEngine;
	
	// 로그인
	@Override
	public Member loginMember(Member inputMember) {

		Member loginMember = mapper.login(inputMember.getMemberId());
		
		
		 String bcryptPassword = bcrypt.encode(loginMember.getMemberPw());
//		 log.debug("bcryptPassword : " + "abcdef");
		
//		 boolean result = bcrypt.matches(inputMember.getMemberPw(), bcryptPassword);
//		 log.debug("result : " + result);
		
		
		if(loginMember == null) return null;
		
		if(!bcrypt.matches(inputMember.getMemberPw(), loginMember.getMemberPw())) {
			return null;
		}
		
		loginMember.setMemberPw(null);
		
		
		
		return loginMember;
	}
	
	// 아이디 찾기
	@Override
	public String idSearch(Map<String, String> paramMap) {
		
		int result = mapper.idCheck(paramMap);
		if(result == 0 ) return null;
		
		return mapper.idSearch(paramMap);
	}


	@Override
	public String pwSearch(Map<String, String> paramMap) {
		
		int result = mapper.pwCheck(paramMap);
		
		if(result == 0 ) return null;
		
		String randomPw = createRandomPw();
		
		try {
			
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true,"UTF-8");
			
			helper.setTo(paramMap.get("search2Email"));
			helper.setSubject("비밀번호 찾기");
			
			helper.setText(loadHtml(randomPw),true);
		
			helper.addInline("logo", new ClassPathResource("static/images/logo.png"));
		
			mailSender.send(mimeMessage);
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
		paramMap.put("randomPw", randomPw);
		
		String bcryptPassword = bcrypt.encode(randomPw);
		
		paramMap.put("bcryptPassword", bcryptPassword);
		
		int updateRandomPw = mapper.updateRandomPw(paramMap);
		
		if(updateRandomPw >0 ) return paramMap.get("randomPw");
		else return null;
	}

	
	// HTML 파일 읽어와서 String으로 변환하기
	private String loadHtml(String randomPw) {
		
		Context context = new Context();
		
		context.setVariable("randomPw", randomPw);
		
		return templateEngine.process("email/searchPw" , context);
	}

	// 인증번호 생성
	 public String createRandomPw() {
		 
		   String key = "";
	       for(int i=0 ; i< 6 ; i++) {
	          
	           int sel1 = (int)(Math.random() * 3); 
	          
	           if(sel1 == 0) {
	              
	               int num = (int)(Math.random() * 10);
	               key += num;
	              
	           }else {
	              
	               char ch = (char)(Math.random() * 26 + 65); 
	              
	               int sel2 = (int)(Math.random() * 2); 
	              
	               if(sel2 == 0) {
	                   ch = (char)(ch + ('a' - 'A')); 
	               }
	              
	               key += ch;
	           }
	          
	       }
	       return key;
	   }

}
