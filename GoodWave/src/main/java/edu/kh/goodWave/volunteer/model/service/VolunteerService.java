package edu.kh.goodWave.volunteer.model.service;

import java.util.Map;

public interface VolunteerService {

	/** 후원 받기 서비스
	 * @param paramMap
	 * @return
	 */
	int moneyDonation(Map<String, Object> paramMap);

}
