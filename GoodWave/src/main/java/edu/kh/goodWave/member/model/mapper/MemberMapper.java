package edu.kh.goodWave.member.model.mapper;

import org.apache.ibatis.annotations.Mapper;

import edu.kh.goodWave.member.model.dto.Member;

@Mapper
public interface MemberMapper {

	/** 멤버 로그인
	 * @param memberId
	 * @return
	 */
	Member login(String memberId);

	/** 맴버 회원가입
	 * @param inputMember
	 * @return
	 */
	int signup(Member inputMember);

	/** 맴버 이메일 중복확인 검사
	 * @param email
	 * @return
	 */
	int checkEmail(String email);

	
}
