package edu.kh.goodWave.editBoard.Exception;

public class ImageUpdateException extends RuntimeException {
	public ImageUpdateException() {
		super("이미지 수정중 문제발송");
	}
	
	public ImageUpdateException(String message) {
		super(message);
	}
}
