package edu.kh.goodWave.member.model.service;

import java.util.Map;

import edu.kh.goodWave.member.model.dto.Member;

public interface MemberService {

	/** 로그인하기
	 * @param inputMember
	 * @return
	 */
	Member loginMember(Member inputMember);

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

}
