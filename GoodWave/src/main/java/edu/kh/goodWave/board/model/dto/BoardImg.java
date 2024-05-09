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
public class BoardImg {
	private int imgNo;
	private String imgPath;
	private String imgOriginalName;
	private String imgRename;
	private int imgOrder;
	private int boardNo;
	
	private MultipartFile uploadFile;
}
