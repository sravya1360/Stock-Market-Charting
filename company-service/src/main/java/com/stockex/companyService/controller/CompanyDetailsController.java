package com.stockex.companyService.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.stockex.companyService.dto.CompanyDetailsDTO;
import com.stockex.companyService.entity.CompanyDetails;
import com.stockex.companyService.services.CompanyDetailsService;

@RestController
@RequestMapping("/api")

public class CompanyDetailsController {

	@Autowired
	ModelMapper mapper;

	private CompanyDetailsService companyService;

	public CompanyDetailsController(CompanyDetailsService companyService) {
		this.companyService = companyService;
	}

	@GetMapping("/company-details/all")
	public ResponseEntity<List<CompanyDetailsDTO>> getAllCompanies() {
		return ResponseEntity.status(HttpStatus.FOUND).body(companyService.getAllCompanies());
	}

	@GetMapping("/company-details/by-name/{name}")
	public ResponseEntity<CompanyDetailsDTO> getCompanyByName(@PathVariable String name){
		return ResponseEntity.status(HttpStatus.FOUND).body(companyService.findByCompanyName(name));
		
	}

	@GetMapping("/company-details/by-id/{id}")
	public ResponseEntity<CompanyDetailsDTO> getCompanyById(@PathVariable Integer id){
		return ResponseEntity.status(HttpStatus.FOUND).body(companyService.findByCompanyId(id));
	}
	
	@GetMapping("/company-details/by-pattern/{pattern}")
	public ResponseEntity<List<CompanyDetailsDTO>> getCompaniesByPattern(@PathVariable String pattern) {
		return ResponseEntity.status(HttpStatus.FOUND).body(companyService.findAllByPattern(pattern));
		
	}
	
	@GetMapping("/company-details/by-sector/{sector}")
	public ResponseEntity<List<CompanyDetailsDTO>> getCompaniesBySector(@PathVariable String sector) {
		return ResponseEntity.status(HttpStatus.FOUND).body(companyService.findAllCompanyBySector(sector));
		
	}
	
	@PostMapping("/company-details/addDetails")
	public ResponseEntity<CompanyDetailsDTO> addCompany(@RequestBody CompanyDetails company){
        return ResponseEntity.status(HttpStatus.CREATED).body(companyService.createCompany(company));
    }
	
	@PutMapping("/company-details/updateCompany/by-id/{id}")
	public ResponseEntity<CompanyDetailsDTO> updateCompany(@RequestBody CompanyDetails company, @PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.CREATED).body(companyService.updateCompany(company,id));
    }
	
	
	
	
}
