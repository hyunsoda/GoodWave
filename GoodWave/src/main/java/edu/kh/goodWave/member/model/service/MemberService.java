package edu.kh.goodWave.member.model.service;

import edu.kh.goodWave.member.model.dto.Member;

public interface MemberService {

	/** 로그인하기
	 * @param inputMember
	 * @return
	 */
	Member loginMember(Member inputMember);

}
