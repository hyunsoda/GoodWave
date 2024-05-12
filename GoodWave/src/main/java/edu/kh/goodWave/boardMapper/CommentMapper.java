package edu.kh.goodWave.boardMapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.kh.goodWave.board.model.dto.Comment;

@Mapper
public interface CommentMapper {

	/** commentList 가져오기
	 * @param boardNo
	 * @return
	 */
	List<Comment> select(int boardNo);

	/** 댓글 등록
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
