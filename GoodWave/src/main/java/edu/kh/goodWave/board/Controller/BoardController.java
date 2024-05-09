package edu.kh.goodWave.board.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.goodWave.board.model.dto.Board;
import edu.kh.goodWave.boardService.BoardService;
import edu.kh.goodWave.member.model.dto.Member;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("board")
@RequiredArgsConstructor
@SessionAttributes({"loginMember"})
@Slf4j
public class BoardController {
	
	private final BoardService service;
	
	// 게시글 상세조회 
	@GetMapping("{boardNo:[0-9]+}")
	public String boardDetail(
			@PathVariable("boardNo") int boardNo,
			Model model,
			RedirectAttributes ra,
			@SessionAttribute(value="loginMember" , required=false) Member loginMember,
			HttpServletRequest req,
			HttpServletResponse resp
			
			) {
		
		Map<String, Object> map = new HashMap<>();
		map.put("boardNo", boardNo);
		
		// 1. 로그인이 되어있을때만 map 에 맴버넘버넣기
		
		if(loginMember != null) {
			map.put("memberNo", loginMember.getMemberNo());
		}
		
		// 2) 서비스 호출 
		
//		Board board = service.selectOne(map);
	
		
		return "";
	}
}
