package com.stockex.companyService.services;

import java.util.List;

import com.stockex.companyService.dto.CompanyDetailsDTO;
import com.stockex.companyService.dto.SectorDTO;
import com.stockex.companyService.entity.Sector;


public interface SectorService {
	
	List<SectorDTO> getAll();
	SectorDTO getById(Integer id);
	List<CompanyDetailsDTO> getAllCompanies(Integer id);
	SectorDTO addSector(Sector sector);
	
	
}
