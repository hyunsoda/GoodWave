package edu.kh.goodWave.boardMapper;

import org.apache.ibatis.annotations.Mapper;

import edu.kh.goodWave.board.model.dto.Board;

@Mapper
public interface BoardMapper {

	/** 삭제되지 않은 게시글 수 조회
	 * @return
	 */
	int getListCount();

	/** 게시글 쓰기
	 * @param board
	 * @return
	 */
	int qnaWrite(Board board);

}
