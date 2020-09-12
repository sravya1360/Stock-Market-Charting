package com.stockEx.excelUploadService.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stockEx.excelUploadService.entity.StockPrice;

@Repository
public interface StockPriceRepo extends JpaRepository<StockPrice, Integer>{
	
	
	
	

}
