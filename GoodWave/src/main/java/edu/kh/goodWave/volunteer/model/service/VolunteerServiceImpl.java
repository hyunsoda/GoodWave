package edu.kh.goodWave.volunteer.model.service;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.goodWave.volunteer.model.dto.Volunteer;
import edu.kh.goodWave.volunteer.model.mapper.VolunteerMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
@RequiredArgsConstructor
public class VolunteerServiceImpl implements VolunteerService{

	private final VolunteerMapper mapper;
	
	@Override
	public int moneyDonation(Map<String, Object> paramMap) {

		return mapper.moneyDonation(paramMap);
	}
	
	
	
	@Override
	public int yeontan(Map<String, Object> paramMap) {
		
		
		return mapper.yeontan(paramMap);
	}
	
	
	@Override
	public int visit(Map<String, Object> paramMap) {

		return mapper.visit(paramMap);
	}

	
	@Override
	public int talent(Map<String, Object> paramMap) {

		return mapper.talent(paramMap);
	}
}
