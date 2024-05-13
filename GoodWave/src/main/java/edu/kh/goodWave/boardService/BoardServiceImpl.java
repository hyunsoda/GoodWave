package edu.kh.goodWave.boardService;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import edu.kh.goodWave.board.model.dto.Board;
import edu.kh.goodWave.board.model.dto.BoardImg;
import edu.kh.goodWave.board.model.dto.Pagenation;
import edu.kh.goodWave.boardMapper.BoardMapper;
import edu.kh.goodWave.common.utility.Utility;
import edu.kh.goodWave.editBoard.Exception.BoardInsertException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
@Slf4j
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
	public int qnaWrite(Board board, List<MultipartFile> images) {

		int result = mapper.qnaWrite(board);
		
		if(result == 0) return 0;
		
		int boardNo = board.getBoardNo();
		
		
		List<BoardImg> uploadLList = new ArrayList<>(); 
		
		
		
		// images 리스트에서 하나씩 꺼내어 선택된 파일이 있는지 검사
		
				for(int i = 0; i < images.size(); i++) {
					
					if(!images.get(i).isEmpty()) {
						// 원본명
						
						String originalName = images.get(i).getOriginalFilename();
						
						// 변경명
						
						String rename = Utility.fileRename(originalName);
						
						
						// 모든 값을 저장할 DTO 생성 (BoardImg)
						
						
						BoardImg img = BoardImg.builder().
								       imgPath("/images/board/").
								       imgOriginalName(originalName).
								       imgRename(rename).
								       boardNo(boardNo).
								       imgOrder(i).
								       uploadFile(images.get(i)).build();
						
						uploadLList.add(img);
						 
						
					}
					
				}
				
				// 선택한 파일이 없을 경우
				
				if(uploadLList.isEmpty()) {
					return boardNo;
				}
				
				// 선택한 파일이 존재할 경우
				// -> Board_img 테이블에 insert + 서버에 파일 저장
				
				
				// reuslt == 삽입된 행의 개수 == uploadList.size()
				result = mapper.insertUploadList(uploadLList);
				
				// 다중 insert 성공 확인 (uploadList에 저장된 값이 모두 정상 삽입 되었나)
				
				if(result == uploadLList.size()) {
					
					// 서버에 파일 저장
					for(BoardImg img : uploadLList) {
						try {
							img.getUploadFile().transferTo(new File("C:/uploadFiles/board/"+img.getImgRename()));
						}catch(Exception e) {
							e.printStackTrace();
						}
						
						 
					}
					
				}else {
					// 부분적으로 삽입 실패 -> 전체 서비스 실패로 판단
					// -> 이전에 삽입된 내용 모두 rollback
					
					// -> rollback 하는 방법
					// == 

					throw new BoardInsertException();
				
				
				
					
				}
				
				log.debug("board_NoOOOO : " + boardNo);
				
				return boardNo;
	}
	
	
	// 게시글 하나 조회
	@Override
	public Board selectOne(Map<String, Integer> map) {
		
		return mapper.selectOne(map);
	}


	@Override

	public int updateReadCount(int boardNo) {
		
		int result = mapper.updateReadCount(boardNo);
		
		
	if(result >0) {
			return mapper.selectReadCount(boardNo);
	}
		
		return -1;
	}

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
