package com.stockex.companyService.services;

import java.util.List;

import com.stockex.companyService.dto.CompanyDetailsDTO;
import com.stockex.companyService.entity.CompanyDetails;

public interface CompanyDetailsService {

	public List<CompanyDetailsDTO> getAllCompanies();

	public CompanyDetailsDTO findByCompanyName(String name);

	public CompanyDetailsDTO findByCompanyId(Integer companyId);

	public List<CompanyDetailsDTO> findAllByPattern(String pattern);

	public List<CompanyDetailsDTO> findAllCompanyBySector(String sector);

	public CompanyDetailsDTO createCompany(CompanyDetails RequestCompanyDetails);

	public CompanyDetailsDTO updateCompany(CompanyDetails RequestCompanyDetails, Integer id);

//	public List<CompanyDetailsDTO> findAllByExchangeListContaining(String stockExchange);

}
