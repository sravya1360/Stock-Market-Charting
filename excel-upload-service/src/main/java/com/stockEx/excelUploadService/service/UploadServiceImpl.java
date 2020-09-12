package com.stockEx.excelUploadService.service;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.stockEx.excelUploadService.entity.StockPrice;
import com.stockEx.excelUploadService.exception.ExcelException;
import com.stockEx.excelUploadService.helper.Helper;
import com.stockEx.excelUploadService.repo.StockPriceRepo;

@Service
public class UploadServiceImpl implements UploadService{
	
	private StockPriceRepo stockPriceRepo;
	

	public UploadServiceImpl(StockPriceRepo stockPriceRepo) {
		this.stockPriceRepo = stockPriceRepo;
	}


	@Override
	public void uploadExcelStockPrices(MultipartFile file) throws ExcelException {
		try {
			List<StockPrice> priceList = Helper.excelToStockPrice(file.getInputStream());
			stockPriceRepo.saveAll(priceList);
		}
		catch (IOException e) {
			throw new ExcelException("Error in storing Excel");
		}
	}
	
}
