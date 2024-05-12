package edu.kh.goodWave.editBoard.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import edu.kh.goodWave.board.model.dto.Board;
import edu.kh.goodWave.board.model.dto.BoardImg;

@Mapper
public interface EditBoardMapper {

	/** 제목 , 내용 수정
	 * @param inputBoard
	 * @return
	 */
	int boardUpdate(Board inputBoard);

	/** 게시글 이미지 삭제
	 * @param map
	 * @return
	 */
	int deleteImage(Map<String, Object> map);

	/** 게시글 이미지 수정
	 * @param img
	 * @return
	 */
	int updateImage(BoardImg img);

	/** 게시글 이미지 삽입
	 * @param img
	 * @return
	 */
	int insertImage(BoardImg img);

	int deleteBoard(Map<String, Integer> map);
	
}
