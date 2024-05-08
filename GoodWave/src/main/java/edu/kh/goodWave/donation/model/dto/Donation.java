package edu.kh.goodWave.donation.model.dto;

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
public class Donation {
	
	private int moneyDonationNo;
	private int moneyDonationTotal;
	private int memberNo;
	private String memberEmail;
	private String memberTel;

}
