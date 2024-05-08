package edu.kh.goodWave.mypage.model.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import edu.kh.goodWave.member.model.dto.Member;

@Mapper
public interface MypageMapper {
	
	/**회원 정보 수정
	 * @param inputMember
	 * @return result
	 */
	int updateInfo(Member inputMember);

	/** 회원 비밀번호 조회
	 * @param memberNo
	 * @return 암호화 된 비밀번호
	 */
	String selectPw(int memberNo);

	/** 비밀번호 변경
	 * @param paramMap
	 * @return result
	 */
	int changePw(Map<String, Object> paramMap);


	/** 회원탈퇴
	 * @param memberNo
	 * @return result
	 */
	int secession(int memberNo);

	/** 활동내역 조회
	 * @return
	 */
	Map<String, Object> selectActivityList();

	/**후원내역 조회
	 * @return
	 */
	Map<String, Object> donationList();

	
	
}
