package com.stockex.companyService.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "sector")
public class Sector {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "sector_id")
	private Integer sectorId;
	
	@Column(name = "sector_name")
	private String sectorName;
	
	@Column(name = "sector_brief")
	private String brief;
//	
//	@OneToMany(mappedBy = "sector", cascade = CascadeType.ALL, orphanRemoval = true)
//	private List<CompanyDetails> companyList;

	public Integer getSectorId() {
		return sectorId;
	}

	public void setSectorId(Integer sectorId) {
		this.sectorId = sectorId;
	}

	public String getSectorName() {
		return sectorName;
	}

	public void setSectorName(String sectorName) {
		this.sectorName = sectorName;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

//	public List<CompanyDetails> getCompanyList() {
//		return companyList;
//	}
//
//	public void setCompanyList(List<CompanyDetails> companyList) {
//		this.companyList = companyList;
//	}
	
//	List<CompanyDetails> companyList

	public Sector() {
	}

	public Sector(Integer sectorId, String sectorName, String brief) {
		this.sectorId = sectorId;
		this.sectorName = sectorName;
		this.brief = brief;
//		this.companyList = companyList;
	}
	
	

}
