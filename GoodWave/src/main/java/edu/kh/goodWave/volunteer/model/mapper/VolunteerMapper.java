package edu.kh.goodWave.volunteer.model.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import edu.kh.goodWave.volunteer.model.dto.Volunteer;

@Mapper
public interface VolunteerMapper {

	/** 후원받기 서비스
	 * @param paramMap
	 * @return result
	 */
	int moneyDonation(Map<String, Object> paramMap);

	/** 연탄봉사 신청 서비스
	 * @param volunteer
	 * @return
	 */
	int yeontan(Map<String, Object> paramMap);

	/** 방문 봉사 신청 서비스
	 * @param paramMap
	 * @return
	 */
	int visit(Map<String, Object> paramMap);

	/** 재능기부 봉사 신청 서비스
	 * @param paramMap
	 * @return
	 */
	int talent(Map<String, Object> paramMap);

	/** 중복 신청 확인 서비스
	 * @param paramMap
	 * @return
	 */
	int check(Map<String, Object> paramMap);

}
