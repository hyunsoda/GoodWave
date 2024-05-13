package edu.kh.goodWave.boardService;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import edu.kh.goodWave.board.model.dto.Board;

public interface BoardService {

	/** 게시판 리스트 조회
	 * @return
	 */
	Map<String, Object> selectBoardList(int cp);

	/** 게시판 작성하기
	 * @param board
	 * @param images 
	 * @return
	 */
	int qnaWrite(Board board, List<MultipartFile> images);

	/** 게시글 하나 조회
	 * @param map
	 * @return
	 */
	Board selectOne(Map<String, Integer> map);


	int updateReadCount(int boardNo);

	/** 게시글 찾기
	 * @param searchInput
	 * @param cp
	 * @return
	 */
	Map<String, Object> search(String searchInput, int cp);


}
