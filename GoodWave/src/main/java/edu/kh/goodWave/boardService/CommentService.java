package edu.kh.goodWave.boardService;

import java.util.List;

import edu.kh.goodWave.board.model.dto.Comment;

public interface CommentService {

	/** commentList 가져오기
	 * @param boardNo
	 * @return
	 */
	List<Comment> select(int boardNo);

	/** 댓글 / 답글 등록
	 * @param comment
	 * @return
	 */
	int insert(Comment comment);

	/** 댓글 삭제
	 * @param commentNo
	 * @return
	 */
	int delete(int commentNo);

	/** 댓글 수정
	 * @param comment
	 * @return
	 */
	int update(Comment comment);

	
	
	
	
	
}
