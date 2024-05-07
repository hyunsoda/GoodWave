package edu.kh.goodWave.boardService;

import java.util.Map;

public interface BoardService {

	/** 게시판 리스트 조회
	 * @return
	 */
	Map<String, Object> selectBoardList();

}
