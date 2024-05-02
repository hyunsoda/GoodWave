package edu.kh.goodWave.member.model.dto;

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
public class Member {

	private int memberNo;
	private String memberId;
	private String memberName;
	private String memberEmail;
	private String memberPw;
	private String memberTel;
	private String memberAddress;
	private String enrollDate;
	private char memberDelFl;
	private int authority;
	
	
	
	/*
	 * 	"MEMBER_NO"	NUMBER		NOT NULL,
	"MEMBER_NAME"	NVARCHAR2(10)		NOT NULL,
	"MEMBER_EMAIL"	NVARCHAR2(50)		NOT NULL,
	"MEMBER_PW"	NVARCHAR2(20)		NOT NULL,
	"MEMBER_TEL"	CHAR(11)		NOT NULL,
	"MEMBER_ADDRESS"	NVARCHAR2(150)		NULL,
	"ENROLL_DATE"	DATE	DEFAULT SYSDATE	NOT NULL,
	"MEMBER_DEL_FL"	CHAR(1)	DEFAULT 'N'	NOT NULL,
	"AUTHORITY"	NUMBER	DEFAULT 1	NOT NULL*/
}
