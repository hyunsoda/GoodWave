package edu.kh.goodWave.boardMapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {

	/** 삭제되지 않은 게시글 수 조회
	 * @return
	 */
	int getListCount();

}
