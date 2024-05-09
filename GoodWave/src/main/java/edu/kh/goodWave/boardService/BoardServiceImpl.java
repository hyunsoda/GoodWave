package edu.kh.goodWave.boardService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import edu.kh.goodWave.board.model.dto.Board;
import edu.kh.goodWave.board.model.dto.Pagenation;
import edu.kh.goodWave.boardMapper.BoardMapper;
import lombok.RequiredArgsConstructor;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
	private final BoardMapper mapper;

	@Override
	public Map<String, Object> selectBoardList(int cp) {
		
		// 삭제되지 않은 게시글 수를 조회
		int listCount = mapper.getListCount();
		

		
		Pagenation pagination = new Pagenation(cp, listCount);
		
		
		int limit = pagination.getLimit();
		
		int offset = (cp - 1) * limit;
		
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		List<Board> boardList = mapper.selectBoardList(rowBounds);
		
		Map<String, Object> map = new HashMap<>();
		
		map.put("pagination", pagination);
		map.put("boardList", boardList);
		
		
		return map;

	}
	
	
	@Override
	public int qnaWrite(Board board) {

		
		return mapper.qnaWrite(board);
	}
	
	
	// 게시글 하나 조회
	@Override
	public Board selectOne(Map<String, Integer> map) {
		
		return mapper.selectOne(map);
	}


	@Override
	public Map<String, Object> search(String searchInput, int cp) {
		
		int listCount = mapper.getSearchCount(searchInput);
		

		
		Pagenation pagination = new Pagenation(cp, listCount);
		
		
		int limit = pagination.getLimit();
		
		int offset = (cp - 1) * limit;
		
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		List<Board> boardList = mapper.selectSearchList(searchInput,rowBounds);
		
		Map<String, Object> map = new HashMap<>();
		
		map.put("pagination", pagination);
		map.put("boardList", boardList);
		
		
		return map;
		
		
		
		
	}

}
