package com.stockex.companyService.services;

import java.util.List;

import com.stockex.companyService.dto.IpoDTO;
import com.stockex.companyService.entity.Ipo;

public interface IpoService {
	List<IpoDTO> getAllIpos();
	IpoDTO getById(Integer id);
	List<IpoDTO> getIpoOfCompany(String companyName);
	IpoDTO addIpo(Ipo ipoDetails);
	
	

}
