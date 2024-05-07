package edu.kh.goodWave.volunteer.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.kh.goodWave.boardService.BoardService;
import lombok.RequiredArgsConstructor;


@Controller
@RequestMapping("community")
@RequiredArgsConstructor
public class CommunityController {

	private final BoardService service;

	@GetMapping("FAQ")
	public String FAQ() {
		
		return "/community/FAQ";
	}
	
	@GetMapping("QNA")
	public String QNA() {
		
		
		Map<String, Object> map = service.selectBoardList();
		
		
		
		
		
		
		return "/community/qnaboard";
	}
	
	
}
