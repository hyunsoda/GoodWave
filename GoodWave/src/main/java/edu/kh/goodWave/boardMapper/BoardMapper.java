package edu.kh.goodWave.boardMapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import edu.kh.goodWave.board.model.dto.Board;

import edu.kh.goodWave.board.model.dto.Board;

@Mapper
public interface BoardMapper {

	/** 삭제되지 않은 게시글 수 조회
	 * @return
	 */
	int getListCount();


	List<Board> selectBoardList(RowBounds rowBounds);

	/** 게시글 쓰기
	 * @param board
	 * @return
	 */
	int qnaWrite(Board board);


	/** 게시글 하나 조회
	 * @param map
	 * @return
	 */
	Board selectOne(Map<String, Integer> map);


}
