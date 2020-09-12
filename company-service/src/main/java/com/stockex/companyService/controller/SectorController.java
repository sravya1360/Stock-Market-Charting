package com.stockex.companyService.controller;

import com.stockex.companyService.dto.CompanyDetailsDTO;
import com.stockex.companyService.dto.IpoDTO;
import com.stockex.companyService.dto.SectorDTO;
import com.stockex.companyService.entity.Sector;
import com.stockex.companyService.services.SectorService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SectorController {

	private SectorService sectorService;

	public SectorController(SectorService sectorService) {
		this.sectorService = sectorService;
	}

	@GetMapping("/sector/get_all")
	public ResponseEntity<List<SectorDTO>> getAll() {
		return new ResponseEntity<List<SectorDTO>>(sectorService.getAll(), HttpStatus.OK);
	}

	@GetMapping("/sector/get_by_id/{id}")
	public ResponseEntity<SectorDTO> getSectorById(@PathVariable("sector_id") Integer id) {
		return new ResponseEntity<SectorDTO>(sectorService.getById(id), HttpStatus.OK);
	}

	@GetMapping("/sector/get_companies/by_sector_id/{sectorId}")
	public ResponseEntity<List<CompanyDetailsDTO>> getCompaniesBySector(@PathVariable("sector_id") Integer sectorId) {
		return new ResponseEntity<List<CompanyDetailsDTO>>(sectorService.getAllCompanies(sectorId), HttpStatus.OK);
	}

	@PostMapping("/sector/add_sector")
	public ResponseEntity<SectorDTO> addIpo(@RequestBody Sector sector) {
		return ResponseEntity.status(HttpStatus.CREATED).body(sectorService.addSector(sector));
	}

}
