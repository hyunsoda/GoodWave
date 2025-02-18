package edu.kh.goodWave.board.model.dto;


import java.util.List;

import edu.kh.goodWave.volunteer.model.dto.Volunteer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Board {
	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private String boardWriteDate;
	private String boardUpdateDate;
	private int readCount;
	private String boardDelFl;
	private int memberNo;
	private int rowNum;
	private String memberName;
	
	
	private int commentCount;
	
	//썸네일 이미지
	
	private String thumbnail;
	
	// --- 추가 예정 ---
		// 특정 게시글 이미지 목록
	private List<BoardImg> imageList;
	
    // 
	
	// 특정 게시글에 작성된 댓글 목록
	
		private List<Comment> commentList;
}
