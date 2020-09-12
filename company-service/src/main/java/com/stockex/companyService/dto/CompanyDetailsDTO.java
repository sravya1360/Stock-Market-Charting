package com.stockex.companyService.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.stockex.companyService.entity.Sector;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



public class CompanyDetailsDTO {
	
	
	
	private String companyName;
	private Long turnover;
	private String ceo;
	private List<String> boardOfDir ;
	private List<String> stockExchanges ;
	private String sector;
	private String brief;
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public Long getTurnover() {
		return turnover;
	}
	public void setTurnover(Long turnover) {
		this.turnover = turnover;
	}
	public String getCeo() {
		return this.ceo;
	}
	public void setCeo(String ceo) {
		this.ceo = ceo;
	}
	public List<String> getBoardOfDir() {
		return boardOfDir;
	}
	public void setBoardOfDir(List<String> boardOfDir) {
		this.boardOfDir = boardOfDir;
	}
	public List<String> getStockExchanges() {
		return stockExchanges;
	}
	public void setStockExchanges(List<String> stockExchanges) {
		this.stockExchanges = stockExchanges;
	}
	public String getSector() {
		return sector;
	}
	public void setSector(String sector) {
		this.sector = sector;
	}
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}

}
