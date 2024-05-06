package edu.kh.goodWave.volunteer.model.dto;

import java.time.LocalDate;

import edu.kh.goodWave.member.model.dto.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Volunteer {
	
	private int memberNo;
	private String yeontanName;
	private String yeontanTel;
	private String yeontanDate;
	
}
