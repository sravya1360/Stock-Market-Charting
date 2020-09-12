package com.stockex.companyService.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "company")
public class CompanyDetails {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "company_id")
	private Integer companyId;

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "ceo")
	private String ceo;
	
	private Long turnover;

	@ElementCollection
	@Column(name = "board_of_directors")
	private List<String> boardOfDir;
	
//	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@JoinTable(name = "company_stock_exchanges", joinColumns = {@JoinColumn(name = "company_id") },
//    inverseJoinColumns = {@JoinColumn(name = "stock_id") })
	@ElementCollection
	private List<String> stockExchange;
//	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@JoinColumn(name = "sector_id")
//	@Column(name = "sector")
	private String sector;

	@Column(name = "brief")
	private String brief;

	@Column(name = "stock_code")
	private String stockCode;

	
	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCeo() {
		return ceo;
	}

	public void setCeo(String ceo) {
		this.ceo = ceo;
	}

	public double getTurnover() {
		return turnover;
	}

	public void setTurnover(Long turnover) {
		this.turnover = turnover;
	}

	public List<String> getBoardOfDir() {
		return boardOfDir;
	}

	public void setBoardOfDir(List<String> boardOfDir) {
		this.boardOfDir = boardOfDir;
	}

	public List<String> getStockExchange() {
		return stockExchange;
	}

	public void setStockExchange(List<String> stockExchange) {
		this.stockExchange = stockExchange;
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

	public String getStockCode() {
		return stockCode;
	}

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}

	public CompanyDetails(Integer companyId, String companyName, String ceo, Long turnover, List<String> boardOfDir,
			List<String> stockExchange, String sector, String brief, String stockCode) {
		this.companyId = companyId;
		this.companyName = companyName;
		this.ceo = ceo;
		this.turnover = turnover;
		this.boardOfDir = boardOfDir;
		this.stockExchange = stockExchange;
		this.sector = sector;
		this.brief = brief;
		this.stockCode = stockCode;
	}

	public CompanyDetails() {
	}
	
	

}
