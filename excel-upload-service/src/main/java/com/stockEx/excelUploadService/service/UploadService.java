package com.stockEx.excelUploadService.service;

import org.springframework.web.multipart.MultipartFile;

import com.stockEx.excelUploadService.exception.ExcelException;

public interface UploadService {
	
	void uploadExcelStockPrices(MultipartFile file) throws ExcelException;

}
