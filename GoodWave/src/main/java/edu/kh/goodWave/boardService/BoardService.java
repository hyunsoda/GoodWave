package edu.kh.goodWave.boardService;

import java.util.Map;

import edu.kh.goodWave.board.model.dto.Board;

public interface BoardService {

	/** 게시판 리스트 조회
	 * @return
	 */
	Map<String, Object> selectBoardList(int cp);

	/** 게시판 작성하기
	 * @param board
	 * @return
	 */
	int qnaWrite(Board board);

}
