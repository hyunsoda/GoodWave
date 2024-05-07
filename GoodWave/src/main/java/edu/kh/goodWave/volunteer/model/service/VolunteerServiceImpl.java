package edu.kh.goodWave.volunteer.model.service;

import java.util.Map;

import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

import edu.kh.goodWave.volunteer.model.dto.Volunteer;
import edu.kh.goodWave.volunteer.model.mapper.VolunteerMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
//@Transactional(rollbackFor = Exception.class)
@Slf4j
@RequiredArgsConstructor
public class VolunteerServiceImpl implements VolunteerService{

	private final VolunteerMapper mapper;
	
	@Override
	public int moneyDonation(Map<String, Object> paramMap) {

		return mapper.moneyDonation(paramMap);
	}
	
	
	// 연탄 봉사 활동 신청
	@Override
	public int yeontan(Map<String, Object> paramMap) {
		
		int result = mapper.check(paramMap);
		
		if(result > 0) {
			return 0;
		}
		
		return mapper.yeontan(paramMap);
	}
	
	// 방문 봉사 활동 신청
	@Override
	public int visit(Map<String, Object> paramMap) {

		int result = mapper.check(paramMap);
		
		if(result > 0) {
			return 0;
		}
		
		return mapper.visit(paramMap);
	}

	// 재능 기부 봉사 활동 신청
	@Override
	public int talent(Map<String, Object> paramMap) {

		int result = mapper.check(paramMap);
		
		if(result > 0) {
			return 0;
		}
		
		return mapper.talent(paramMap);
	}
}
