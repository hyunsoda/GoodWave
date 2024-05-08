package edu.kh.goodWave.boardMapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import edu.kh.goodWave.board.model.dto.Board;

@Mapper
public interface BoardMapper {

	/** 삭제되지 않은 게시글 수 조회
	 * @return
	 */
	int getListCount();

	List<Board> selectBoardList(RowBounds rowBounds);

}
