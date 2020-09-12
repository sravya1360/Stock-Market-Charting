package com.stockex.companyService.services;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stockex.companyService.dto.CompanyDetailsDTO;
import com.stockex.companyService.entity.CompanyDetails;
import com.stockex.companyService.repository.CompanyDetailsRepo;
import java.util.*;

@Service
@Transactional
public class CompnayDetailsServiceImpl implements CompanyDetailsService {

	private ModelMapper modelMapper;
	private CompanyDetailsRepo companyDetailsRepo;
	
	public CompnayDetailsServiceImpl(CompanyDetailsRepo companyRepo, ModelMapper modelMapper) {
		this.companyDetailsRepo = companyRepo;
		this.modelMapper = modelMapper;
	}

	@Override
	public List<CompanyDetailsDTO> getAllCompanies() {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		Type listType = new TypeToken<List<CompanyDetailsDTO>>() {
		}.getType();
		return modelMapper.map(companyDetailsRepo.findAll(), listType);

	}

	@Override
	public CompanyDetailsDTO findByCompanyName(String name) {
		CompanyDetails company = companyDetailsRepo.findByCompanyName(name);
		if (company != null) {
			modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
			return modelMapper.map(company, CompanyDetailsDTO.class);
		}
		// TODO: THROW An EXCEPTION HERE
		return null;
	}

	@Override
	public CompanyDetailsDTO findByCompanyId(Integer companyId) {
		Optional<CompanyDetails> company = companyDetailsRepo.findById(companyId);
		if (company.isPresent()) {
			modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
			return modelMapper.map(company, CompanyDetailsDTO.class);
		}
		// TODO: THROW An EXCEPTION HERE
		return null;

	}

	@Override
	public List<CompanyDetailsDTO> findAllByPattern(String pattern) {

		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		Type listType = new TypeToken<List<CompanyDetailsDTO>>() {
		}.getType();
		return modelMapper.map(companyDetailsRepo.findByCompanyNameContaining(pattern), listType);

	}

	@Override
	public List<CompanyDetailsDTO> findAllCompanyBySector(String sector) {

		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		Type listType = new TypeToken<List<CompanyDetailsDTO>>() {
		}.getType();
		return modelMapper.map(companyDetailsRepo.findAllBySector(sector), listType);
	}

	@Override
	public CompanyDetailsDTO createCompany(CompanyDetails companyDetails) {
		companyDetailsRepo.save(companyDetails);
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		CompanyDetailsDTO companyDto = modelMapper.map(companyDetails, CompanyDetailsDTO.class);
		return companyDto;

	}

	@Override
	public CompanyDetailsDTO updateCompany(CompanyDetails companyDetails, Integer companyId) {
		Optional<CompanyDetails> optionalCompany = companyDetailsRepo.findById(companyId);
		if (!optionalCompany.isPresent()) {
			companyDetailsRepo.save(companyDetails);
			modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
			CompanyDetailsDTO companyDto = modelMapper.map(companyDetails, CompanyDetailsDTO.class);
			return companyDto;
		}
		companyDetailsRepo.deleteById(companyId);
		companyDetailsRepo.save(companyDetails);
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		CompanyDetailsDTO companyDto = modelMapper.map(companyDetails, CompanyDetailsDTO.class);
		return companyDto;
	}

}
