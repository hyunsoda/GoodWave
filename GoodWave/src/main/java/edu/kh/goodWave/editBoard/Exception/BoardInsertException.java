package edu.kh.goodWave.editBoard.Exception;

public class BoardInsertException extends RuntimeException {
	public BoardInsertException() {
		super("오류 발생");
	}
	
	public BoardInsertException(String message) {
		super(message);
	}
}
