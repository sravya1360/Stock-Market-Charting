package com.stockex.companyService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stockex.companyService.entity.Ipo;

@Repository
public interface IpoRepo extends JpaRepository<Ipo, Integer>{
	
	List<Ipo> findByCompanyName(String companyName); 

}
