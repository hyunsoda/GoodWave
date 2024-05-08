package edu.kh.goodWave.volunteer.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.goodWave.board.model.dto.Board;
import edu.kh.goodWave.boardService.BoardService;
import edu.kh.goodWave.member.model.dto.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Controller
@RequestMapping("community")
@RequiredArgsConstructor
@Slf4j
public class CommunityController {

	private final BoardService service;

	@GetMapping("FAQ")
	public String FAQ() {
		
		return "/community/FAQ";
	}
  
  
	
	@GetMapping("QNA")
	public String QNA(
			@RequestParam(value="cp" , required=false, defaultValue="1") int cp,
			Model model
			) {
  
      Map<String, Object> map = service.selectBoardList(cp);
		
		
		model.addAttribute("pagination", map.get("pagination"));
		model.addAttribute("boardList", map.get("boardList"));
  
  
return "redirect:/community/qnaboard";

}
  
  
  

	@GetMapping("qnaboard")
	public String QNA() {
		return "/community/qnaboard";
	}

	
	@GetMapping("qnawrite")
	public String QNAwrite() {
		return "/community/qnawrite";
	}
	
	@PostMapping("qnawrite")
	public String QNAwrite(Board board,
							RedirectAttributes ra,
							@SessionAttribute("loginMember") Member loginMember) {

		
		board.setMemberNo(loginMember.getMemberNo());
		

		

		int result = service.qnaWrite(board);
		
		if(result >0) {
			
			ra.addFlashAttribute("message", "등록되었습니다.");
			return "redirect:/community/qnaboard";
		} else {
			
			ra.addFlashAttribute("message", "등록이 완료되지 않았습니다. 다시 작성해주세요");
			return "redirect:/community/qnawrite";
		}

		
		
		
	}
	
	
	
	
	
	@GetMapping("Comment")
	public String Comment() {
		return "/community/Comment";
	}
	
	@GetMapping("QNAupdate")
	public String QNAupdate() {
		return "/community/QNAupdate";
	}
	
	
	
	
	
	
}
