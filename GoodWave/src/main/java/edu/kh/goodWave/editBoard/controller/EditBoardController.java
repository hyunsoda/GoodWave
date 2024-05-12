package edu.kh.goodWave.editBoard.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ListModel;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
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
	
	
	@GetMapping("{boardNo:[0-9]+}/delete")
	public String deleteBoard(
			Model model,
			@SessionAttribute("loginMember") Member loginMember,
			@PathVariable("boardNo") int boardNo,
			@RequestParam("cp") int cp,
			RedirectAttributes ra
			) {
		
		log.debug("값");
		Map<String, Integer> map = new HashMap<>();
		
		
		map.put("memberNo", loginMember.getMemberNo());		
		map.put("boardNo", boardNo);
		
		int result = editBoardService.deleteBoard(map);
		
		String message = null;
		
		if(result > 0) {
			message = "게시글 삭제 완료";
		}
		model.addAttribute("cp", cp);		
		ra.addFlashAttribute("message", message);		
		return "redirect:/community/QNA";
	}
	
	/** 오버로딩 적용 update 완료 구문
	 * @return
	 */
	@PostMapping("{boardNo:[0-9]+}")
	public String boardUpdate(
			@PathVariable("boardNo") int boardNo,
			@RequestParam("cp") int cp,
			Board inputBoard,
			@SessionAttribute("loginMember") Member loginMember,
			@RequestParam("images") List<MultipartFile> images,
			RedirectAttributes ra,
			@RequestParam(value = "deleteOrder", required=false) String deleteOrder,
			@RequestParam(value = "queryString", required=false, defaultValue = "") String queryString
			) {
		
		log.debug("tqtq tqtqtqtqtqtq: ");		
		inputBoard.setBoardNo(boardNo);
		inputBoard.setMemberNo(loginMember.getMemberNo());
		
		log.debug("images :" + images);		
		// 2. 게시글 수정 서비스 호출하고 결과 반환 받을거임
		
		int result = editBoardService.boardUpdate(inputBoard, images, deleteOrder) ;
		
		// 3. 서비스 결과에 따라 응답 제어
		
		String message = null;
		String path = null;
		
		if(result > 0) {
			message = "게시글이 수정 되었습니다";
			path = String.format("/board/%d?cp=%d", boardNo,cp);// editBoard/50?cp=1
		}else {
			message = "수정 실패";
			path = String.format("/board/%d?cp=%d", boardNo,cp);		}
		
		ra.addFlashAttribute("message", message);
		
		
		return "redirect:" + path;
	}
	
	
	
	/** 게시글 상세조회 해서 화면에 뿌리는 거
	 * @param boardNo
	 * @param loginMember
	 * @param model
	 * @param ra
	 * @param cp
	 * @return
	 */
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
		model.addAttribute("cp", cp);		log.debug("image : " + board.getImageList());
		
		return path;
	}
	
}
