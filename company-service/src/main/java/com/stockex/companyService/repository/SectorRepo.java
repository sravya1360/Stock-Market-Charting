package com.stockex.companyService.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stockex.companyService.entity.Sector;

@Repository
public interface SectorRepo extends JpaRepository<Sector, Integer>{
//	
//	List<CompanyDetails> findAllCompaniesById(Integer id);
//	Sector findSectorBYId(Integer)

}
