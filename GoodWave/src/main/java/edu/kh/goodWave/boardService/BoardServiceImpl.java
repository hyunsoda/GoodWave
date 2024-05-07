package edu.kh.goodWave.boardService;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.goodWave.boardMapper.BoardMapper;
import lombok.RequiredArgsConstructor;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
	private final BoardMapper mapper;

	@Override
	public Map<String, Object> selectBoardList() {
		
		// 삭제되지 않은 게시글 수를 조회
		int listCount = mapper.getListCount();
		
		
		
		
		return null;
	}
	
}
