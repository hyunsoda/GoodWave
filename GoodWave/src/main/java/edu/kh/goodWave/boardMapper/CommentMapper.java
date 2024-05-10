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

}
