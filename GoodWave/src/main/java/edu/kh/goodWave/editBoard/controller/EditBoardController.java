package edu.kh.goodWave.editBoard.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.goodWave.board.model.dto.Board;
import edu.kh.goodWave.boardService.BoardService;
import edu.kh.goodWave.editBoard.service.EditBoardService;
import edu.kh.goodWave.member.model.dto.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("editBoard")
@Slf4j
@RequiredArgsConstructor
@SessionAttributes({"loginMember"})
@Controller
public class EditBoardController {
   
	private final EditBoardService editBoardService;
	private final BoardService boardService;
	
	@GetMapping("{boardNo:[0-9]+}")
	public String boardUpdate(
			 @PathVariable("boardNo") int boardNo,
			 @SessionAttribute("loginMember") Member loginMember,
			 Model model,
			 RedirectAttributes ra,
			 @RequestParam(value="cp", required=false) int cp
			) {
		
		Map<String, Integer> map = new HashMap<>();
		map.put("boardNo", boardNo);
		
		Board board = boardService.selectOne(map);
		
		
		
		String message = null;
		String path = null;
		
		if(board == null) {
			message = "해당 게시글이 존재하지 않습니다";
			path = "redirect:/";
		}else if(board.getMemberNo() != loginMember.getMemberNo()) {
			message = "자신이 작성한 글만 수정할 수 있습니다";
			
			path = String.format("redirect:/board/%d?cp=%d",boardNo,cp);
		}
		
		
		path = "board/boardUpdate";
		model.addAttribute("board",board);
		model.addAttribute("message", message);
		model.addAttribute("start", 0);
		log.debug("image : " + board.getImageList());
		
		return path;
	}
	
}
