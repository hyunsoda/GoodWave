package edu.kh.goodWave.volunteer.model.service;

import java.util.Map;

import edu.kh.goodWave.volunteer.model.dto.Volunteer;

public interface VolunteerService {

	/** 후원 받기 서비스
	 * @param paramMap
	 * @return
	 */
	int moneyDonation(Map<String, Object> paramMap);

	/** 연탄 봉사 신청
	 * @param yeontanMap
	 * @return
	 */
	int yeontan(Map<String, Object> paramMap );

	/** 방문 봉사 신청
	 * @param paramMap
	 * @return
	 */
	int visit(Map<String, Object> paramMap);

	/** 재능 기부 봉사 신청
	 * @param paramMap
	 * @return
	 */
	int talent(Map<String, Object> paramMap);

}
