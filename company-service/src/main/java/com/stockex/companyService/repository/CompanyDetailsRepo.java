package com.stockex.companyService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stockex.companyService.entity.CompanyDetails;

@Repository
public interface CompanyDetailsRepo extends JpaRepository<CompanyDetails, Integer> {

	public List<CompanyDetails> findByCompanyNameContaining(String pattern);

	public CompanyDetails findByCompanyName(String companyName);

	public List<CompanyDetails> findAllBySector(String sector);


}
