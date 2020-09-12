package com.stockex.companyService.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "ipo")
public class Ipo {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ipo_id")
	private Integer id;
	
	private String companyName;
	
	private String stockExchange;
	
	private Long pricePerShare;
	
	private Long totalShares;
	
	@DateTimeFormat(iso = ISO.DATE)
	private Date date;
	
	private String remarks;

	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getStockExchange() {
		return stockExchange;
	}

	public void setStockExchange(String stockExchange) {
		this.stockExchange = stockExchange;
	}

	public Long getPricePerShare() {
		return pricePerShare;
	}

	public void setPricePerShare(Long pricePerShare) {
		this.pricePerShare = pricePerShare;
	}

	public Long getTotalShares() {
		return totalShares;
	}

	public void setTotalShares(Long totalShares) {
		this.totalShares = totalShares;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Ipo(Integer id, String companyName, String stockExchange, Long pricePerShare, Long totalShares, Date date,
			String remarks) {
		this.id = id;
		this.companyName = companyName;
		this.stockExchange = stockExchange;
		this.pricePerShare = pricePerShare;
		this.totalShares = totalShares;
		this.date = date;
		this.remarks = remarks;
	}
	
	public Ipo() {
	}
	
	
	

}
