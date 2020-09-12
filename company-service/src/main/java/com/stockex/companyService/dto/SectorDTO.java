package com.stockex.companyService.dto;

import java.util.List;

import com.stockex.companyService.entity.CompanyDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class SectorDTO {
	
	private String sectorName;
	private String brief;
//	private List<CompanyDetails> companydetails;
	public String getSectorName() {
		return sectorName;
	}
	public void setSectorName(String sector_name) {
		this.sectorName = sector_name;
	}
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
//	public List<CompanyDetails> getCompanydetails() {
//		return companydetails;
//	}
//	public void setCompanydetails(List<CompanyDetails> companydetails) {
//		this.companydetails = companydetails;
//	}
//	
	

}
