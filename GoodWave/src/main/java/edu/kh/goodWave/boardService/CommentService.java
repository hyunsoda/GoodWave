package edu.kh.goodWave.boardService;

import java.util.List;

import edu.kh.goodWave.board.model.dto.Comment;

public interface CommentService {

	/** commentList 가져오기
	 * @param boardNo
	 * @return
	 */
	List<Comment> select(int boardNo);

	
	
	
	
	
}
