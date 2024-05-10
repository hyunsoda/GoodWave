package edu.kh.goodWave.board.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.kh.goodWave.board.model.dto.Comment;
import edu.kh.goodWave.boardService.CommentService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("comment")
@RequiredArgsConstructor
public class CommentController {

	private final CommentService service;
	
	
	
	/** CommentList 가져오기
	 * @param boardNo
	 * @return
	 */
	@GetMapping("")     // /comment
	public List<Comment> select(@RequestParam("boardNo") int boardNo){
		
		// HttpMessageConverter가 
		// List -> JSON (문자열)로 변환해서 응답
		
		return service.select(boardNo);
		
	}
	
	
	
}
