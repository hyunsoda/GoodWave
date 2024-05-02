package edu.kh.goodWave.volunteer.model.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface VolunteerMapper {

	/** 후원받기 서비스
	 * @param paramMap
	 * @return result
	 */
	int moneyDonation(Map<String, Object> paramMap);

}
