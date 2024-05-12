package edu.kh.goodWave.board.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.kh.goodWave.board.model.dto.Comment;
import edu.kh.goodWave.boardService.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("comment")
@RequiredArgsConstructor
@Slf4j
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
	
	
	/** 댓글/ 답글 등록
	 * @param comment
	 * @return
	 */
	@PostMapping("")
	public int insert(@RequestBody Comment comment) {
		
		log.debug("originalcommentNo"+comment.getOriginalCommentNo());
		return service.insert(comment);
	}
	
	
	/** 댓글 삭제
	 * @param commentNo
	 * @return
	 */
	@DeleteMapping("")
	public int delete(@RequestBody int commentNo) {
		
		return service.delete(commentNo);
	}
	
	/**  댓글 수정
	 * @param comment
	 * @return
	 */
	@PutMapping("")
	public int update(@RequestBody Comment comment) {
		
		return service.update(comment);
	}
	
	
}
