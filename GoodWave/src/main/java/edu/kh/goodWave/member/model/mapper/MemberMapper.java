package edu.kh.goodWave.member.model.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import edu.kh.goodWave.member.model.dto.Member;

@Mapper
public interface MemberMapper {

	/** 멤버 로그인
	 * @param memberId
	 * @return
	 */
	Member login(String memberId);

	/** 아이디 찾기
	 * @param paramMap
	 * @return
	 */
	String idSearch(Map<String, String> paramMap);

	/** 검색하는 아이디가 있는지 확인하기
	 * @param paramMap
	 * @return
	 */
	int idCheck(Map<String, String> paramMap);

	/** 검색하는 회원정보가 있는지 확인하기 (비밀번호 찾기)
	 * @param paramMap
	 * @return
	 */
	int pwCheck(Map<String, String> paramMap);

	/** 랜덤 비밀번호로 업데이트
	 * @param paramMap
	 * @return
	 */
	int updateRandomPw(Map<String, String> paramMap);

	
}
