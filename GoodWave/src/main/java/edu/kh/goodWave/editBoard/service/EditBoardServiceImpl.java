package edu.kh.goodWave.editBoard.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.goodWave.editBoard.mapper.EditBoardMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
@RequiredArgsConstructor
public class EditBoardServiceImpl implements EditBoardService{
 
	private final EditBoardMapper mapper;
	 
}
