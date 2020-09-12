package com.stockEx.excelUploadService.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.stockEx.excelUploadService.exception.ExcelException;
import com.stockEx.excelUploadService.helper.Helper;
import com.stockEx.excelUploadService.service.UploadService;

@RestController
@RequestMapping("/api")
public class UploadController {

	UploadService uploadService;

	public UploadController(UploadService uploadService) {
		super();
		this.uploadService = uploadService;
	}

	@PostMapping("/exceUpload")
	public ResponseEntity<Object> uploadExcel(@RequestParam("file") MultipartFile file) {
		if (Helper.hasExcelFormat(file)) {
			try {
				uploadService.uploadExcelStockPrices(file);
				ResponseEntity.status(HttpStatus.OK);
			} catch (ExcelException e) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());

			}

		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Check Uploaded File Format");
		}
		return null;
	}

}
