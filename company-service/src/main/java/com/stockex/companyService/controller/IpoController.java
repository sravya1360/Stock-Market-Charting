package com.stockex.companyService.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.stockex.companyService.dto.CompanyDetailsDTO;
import com.stockex.companyService.dto.IpoDTO;
import com.stockex.companyService.entity.Ipo;
import com.stockex.companyService.services.IpoService;

@RestController
@RequestMapping("/api")
public class IpoController {

	private IpoService ipoService;

	public IpoController(IpoService ipoService) {
		this.ipoService = ipoService;
	}

	@GetMapping("/getIpo/all")
	public ResponseEntity<List<IpoDTO>> getAllIpos() {
		return ResponseEntity.status(HttpStatus.FOUND).body(ipoService.getAllIpos());
	}

	@GetMapping("/getIpo/by-id/{id}")
	public ResponseEntity<IpoDTO> getIpoById(@PathVariable Integer id) {
		return ResponseEntity.status(HttpStatus.FOUND).body(ipoService.getById(id));

	}

	@GetMapping("/getIpo/by-company/{name}")
	public ResponseEntity<List<IpoDTO>> getIposOfCompany(@PathVariable String name) {
		return ResponseEntity.status(HttpStatus.FOUND).body(ipoService.getIpoOfCompany(name));
	}

	@PostMapping("/addIpo")
	public ResponseEntity<IpoDTO> addIpo(@RequestBody Ipo ipo) {
		return ResponseEntity.status(HttpStatus.CREATED).body(ipoService.addIpo(ipo));
	}

}
