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

	
}
