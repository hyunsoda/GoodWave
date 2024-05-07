package edu.kh.goodWave.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

import edu.kh.goodWave.member.model.dto.Member;
import edu.kh.goodWave.member.model.mapper.MemberMapper;
import lombok.extern.slf4j.Slf4j;

//@Transactional(rollbackFor=Exception.class)
@Service
@Slf4j
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberMapper mapper;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
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
}
