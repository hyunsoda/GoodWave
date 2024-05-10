package edu.kh.goodWave.mypage.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.PropertySource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import edu.kh.goodWave.donation.model.dto.Donation;
import edu.kh.goodWave.member.model.dto.Member;
import edu.kh.goodWave.mypage.model.mapper.MypageMapper;
import edu.kh.goodWave.volunteer.model.dto.Volunteer;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@PropertySource("classpath:/config.properties")
public class MyPageServiceImpl implements MyPageService {
	
private final MypageMapper mapper;
	
	// Bcrypt 암호화 객체 의존성 주입(SecurityConfig 참고)
	private final BCryptPasswordEncoder bcrypt;

	
	//회원 정보 수정
	@Override
	public int updateInfo(Member inputMember, String[] memberAddress) {
		
		// 입력된 주소가 있을 경우
		// memberAddress를 A^^^B^^^C 형태로 가공해야한다.

		// 주소 입력 안했을 경우 -> inputMember.getMemberAddress() -> ",,"
		if (inputMember.getMemberAddress().equals(",,")) {

			// 주소에 null 대입
			inputMember.setMemberAddress(null);
		} else {
			// memberAddress를 A^^^B^^^C 형태로 가공
			String address = String.join("^^^", memberAddress);

			// 주소에 가공된 데이터를 대입
			inputMember.setMemberAddress(address);
		}

	// SQL 수행 후 결과 반환
	return mapper.updateInfo(inputMember);
	
	
	}

	
	//비밀번호 변경
	@Override
	public int changePw(Map<String, Object> paramMap, int memberNo) {
		
		// 현재 로그인한 회원의 암호화된 비밀번호를 DB에서 조회
		String originPw = mapper.selectPw(memberNo);

		// 입력 받은 현재 비밀번호와 (평문상태)
		// DB에서 조회한 비밀번호 비교 (암호화)
		// BcryptPasswordEncoder.matches (평문, 암호화된 비밀번호)

		// 다를 경우
		if (!bcrypt.matches((String) paramMap.get("currentPw"), originPw)) {
			return 0;
		}
		// 같을 경우

		// 새 비밀번호를 암호화 진행
		String encPw = bcrypt.encode((String) paramMap.get("newPw"));

		paramMap.put("encPw", encPw);
		paramMap.put("memberNo", memberNo);

		return mapper.changePw(paramMap);
	
	}

	
	//회원탈퇴
	@Override
	public int secession(String memberPw, int memberNo) {
		
		// 현재 로그인한 회원의 암호화된 비밀번호를 DB에서 조회
				String originPw = mapper.selectPw(memberNo);

				// 다를 경우
				if (!bcrypt.matches(memberPw, originPw)) {
					return 0;
				}

				return mapper.secession(memberNo);
	
	}




	//후원내역조회
	@Override
	public List<Donation> selectDonationList(int memberNo) {
		
		return mapper.selectDonationList(memberNo);
	}


	//활동내역조회
	@Override
	public List<Volunteer> applyList(int memberNo) {
		return mapper.applyList(memberNo);
	}

	//신청 취소
	@Override
	public int cancle(Volunteer volunteer) {
		return mapper.cancle(volunteer);
	}



}
