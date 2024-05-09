package edu.kh.goodWave.board.model.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Comment {
		private int commentNo;
		private String commentContent;
		private String commentWriteDate;
		private String commentDelFl;
		private int boardNo;
		private int memberNo;
		private int originalCommentNo;
		
		// 댓글 조회 시 회원 프로필 , 닉네임
		
		private String memberName;
		
		// private String profileImg << 우린 맴버이미지를 안넣어놧음
}
