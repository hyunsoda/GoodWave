package edu.kh.goodWave.editBoard.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ListModel;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import edu.kh.goodWave.board.model.dto.Board;
import edu.kh.goodWave.board.model.dto.BoardImg;
import edu.kh.goodWave.common.utility.Utility;
import edu.kh.goodWave.editBoard.Exception.ImageDeleteException;
import edu.kh.goodWave.editBoard.Exception.ImageUpdateException;
import edu.kh.goodWave.editBoard.mapper.EditBoardMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
@RequiredArgsConstructor
@PropertySource("classpath:/config.properties")
public class EditBoardServiceImpl implements EditBoardService{
 
	private final EditBoardMapper mapper;

	/**
	 * 게시글 수정
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@Override
	public int boardUpdate(Board inputBoard, List<MultipartFile> images, String deleteOrder){
		
		// 제목 내용 부분만 수정
		int result = mapper.boardUpdate(inputBoard);
		
		// 제목 내용 수정 실패 시 바로 리턴
		
		if(result == 0) {
			return 0;
		}
		
		//-----------------------------------------------------
		
		// 제목 내용 수정 완료가 되면
		
		// 2. 기존에 이미지가 있었는데 없어진 경우 
		//deleteOrder 로 가져왓음 순서를
		
		if(deleteOrder != null && !deleteOrder.equals("")){
			Map<String, Object> map = new HashMap<>();
			
			map.put("deleteOrder", deleteOrder);
			map.put("boardNo", inputBoard.getBoardNo());
			
			result = mapper.deleteImage(map);
			
			// 삭제 실패한 경우(부분 실패 포함) -> 롤백 
			
			if(result == 0) {
				throw new ImageDeleteException();
			}
			
			//바 깥 쪽 if
					}
				//바 깥 쪽 if
			
			
			// 3. 선택한 파일이 존재할 경우
			// 이미지도 삭제되고, 제목 내용도 수정 됐으면
			// 가져온 이미지를 넣어줄거임
			
			List<BoardImg> uploadList = new ArrayList<>();
			
			for(int i = 0; i< images.size(); i++) {
				
				if(!images.get(i).isEmpty() ) {
					
					String originalName = images.get(i).getOriginalFilename();
					
					String rename = Utility.fileRename(originalName);
					
					BoardImg img = BoardImg.builder().
								  imgOriginalName(originalName).
								  imgRename(rename).
								  imgPath("/images/board/").
								  imgOrder(i).
								  boardNo(inputBoard.getBoardNo()).
								  uploadFile(images.get(i)).build();	
					
					uploadList.add(img);
					
					// 업로드 하려는 이미지 정보 (img 객체)
					// 수정 또는 삽입 수행
					
					// update 하는 sql 부터 수행 수정해서 결과가 0 이면 insert
					
					result = mapper.updateImage(img);
					
					if(result == 0) {
						// 수정 실패 == 기존 해당 순서(IMG_ORDER)에 이미지가 없었음
						
						result = mapper.insertImage(img);
						
						// 수정 IF
					}
					// 수정 IF
					
					//if문
					}
				//if문
				
				// 수정 또는 삭제가 실패한 경우
				
				 if(result == 0) {
					 throw new ImageUpdateException();
				 }
				
				//for문
			}
			//for문
			
			//선택한 파일이 없을 경우
			if(uploadList.isEmpty()) {
				return result;
			}
			
			// 수정 이미지 파일을 서버에 저장
			
			
			for(BoardImg img : uploadList) {
				try {
					img.getUploadFile().transferTo(new File("C:/uploadFiles/board/"+img.getImgRename()));
				}catch(Exception e) {
					e.printStackTrace();
				}
				
			}
	
		
		
		
		
		return result;
	}

	@Override
	public int deleteBoard(Map<String, Integer> map) {
		
		
		return mapper.deleteBoard(map);
	}
	 
}
