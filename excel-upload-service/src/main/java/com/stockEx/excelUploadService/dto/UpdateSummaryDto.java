package com.stockEx.excelUploadService.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class UpdateSummaryDto {

	private String companyCode;

	private String stockExchange;

	private int numRecords;

	@DateTimeFormat(iso = ISO.DATE)
	private Date fromDate;

	@DateTimeFormat(iso = ISO.DATE)
	private Date toDate;

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getStockExchange() {
		return stockExchange;
	}

	public void setStockExchange(String stockExchange) {
		this.stockExchange = stockExchange;
	}

	public int getNumRecords() {
		return numRecords;
	}

	public void setNumRecords(int numRecords) {
		this.numRecords = numRecords;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public UpdateSummaryDto(String companyCode, String stockExchange, int numRecords, Date fromDate, Date toDate) {
		super();
		this.companyCode = companyCode;
		this.stockExchange = stockExchange;
		this.numRecords = numRecords;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}

	public UpdateSummaryDto() {
		super();
	}

}
