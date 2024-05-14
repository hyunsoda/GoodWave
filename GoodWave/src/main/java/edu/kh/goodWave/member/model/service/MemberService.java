package edu.kh.goodWave.member.model.service;

import java.util.Map;

import edu.kh.goodWave.member.model.dto.Member;

public interface MemberService {

	/** 로그인하기
	 * @param inputMember
	 * @return
	 */
	Member loginMember(Member inputMember);


	/** 회원가입
	 * @param inputMember
	 * @param member
	 * @return
	 */
	int signup(Member inputMember, String[] member);

	/** 이메일 중복체크
	 * @param email
	 * @return
	 */
	int checkEmail(String email);

	/**아이디 찾기 
	 * @param paramMap
	 * @return
	 */
	String idSearch(Map<String, String> paramMap);



	/** 비밀번호 찾기
	 * @param paramMap
	 * @return
	 */
	String pwSearch(Map<String, String> paramMap);


	int checkMemberId(String memberId);


}
