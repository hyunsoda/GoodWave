package edu.kh.goodWave.mypage.model.service;

import java.util.Map;

import edu.kh.goodWave.member.model.dto.Member;

public interface MyPageService {

	/**회원 정보 수정
	 * @param inputMember
	 * @param memberAddress
	 * @return result
	 */
	int updateInfo(Member inputMember, String[] memberAddress);

	/** 비밀번호 변경
	 * @param paramMap
	 * @param memberNo
	 * @return result
	 */
	int changePw(Map<String, Object> paramMap, int memberNo);


	/**회원탈퇴
	 * @param memberPw
	 * @param memberNo
	 * @return result
	 */
	int secession(String memberPw, int memberNo);

	/** 활동 내역 조회
	 * @param memberNo
	 * @return
	 */
	Map<String, Object> selectActivityList(int memberNo);

	/** 후원내역 조회
	 * @param memberNo
	 * @return
	 */
	Map<String, Object> donationList(int memberNo);


}
