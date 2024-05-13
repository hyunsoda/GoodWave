package edu.kh.goodWave.editBoard.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.swing.ListModel;

import org.springframework.web.multipart.MultipartFile;

import edu.kh.goodWave.board.model.dto.Board;

public interface EditBoardService {

	/** 게시글 수정
	 * @param inputBoard
	 * @param images
	 * @param deleteOrder
	 * @return
	 */
	int boardUpdate(Board inputBoard, List<MultipartFile> images, String deleteOrder);

	int deleteBoard(Map<String, Integer> map);

}
