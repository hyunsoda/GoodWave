package edu.kh.goodWave.boardService;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.goodWave.board.model.dto.Comment;
import edu.kh.goodWave.boardMapper.CommentMapper;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{

	private final CommentMapper mapper;
	
	
	@Override
	public List<Comment> select(int boardNo) {

		
		return mapper.select(boardNo);
	}
	
} 
