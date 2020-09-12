package com.stockEx.excelUploadService.exception;

public class ExcelException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;

	public ExcelException(String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
	

}
